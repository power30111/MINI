package security1.security.config.auth;



//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다..
// 이떄 로그인을 진행이 완료가 될경우 session을 만들어준다. (Security ContextHolder) <- 이 키값을 세션에 저장
// Security의 session 에 들어갈수있는 object가 정해져있다. ==> Authentication type 객체여야한다.
// Authentication 안에는 User정보가 있어야한다.
// User 객체의 type => UserDetails type 객체

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import security1.security.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {
    // UserDetails을 상속받는다.

    private User user; //콤포지션?
    private Map<String,Object> attributes;

    public PrincipalDetails(User user) {
        this.user = user;
        //일반 로그인할시 사용하는 생성자
    }

    public PrincipalDetails(User user, Map<String,Object> attributes){
        this.user = user;
        this.attributes = attributes;
        //OAuth 로그인 할시 사용하는 생성자( attribute를 통해서 user를 만든다.)
    }

    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //해당 User의 권한을 return 하는 메서드.!!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();

        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        //계정 만료되었는지 물어보는 메서드.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금되어있는 건지 물어보는 메서드
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //비번 오래 사용한거임?
        return true;
    }

    @Override
    public boolean isEnabled() {
        //계정 활성화 되어있음?
        //그럼 언제 false로 해야하지?
        //-> 내가 만든 사이트에서 1년동안 사용안할경우 계정 비활성화 해야할경우 접속기록 참고해서 ..

        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
