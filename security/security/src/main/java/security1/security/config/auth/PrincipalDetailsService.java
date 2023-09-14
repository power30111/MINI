package security1.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security1.security.model.User;
import security1.security.repository.UserRepository;

//시큐리티 설정에서 loginProcessingUrl("login");
// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어있는 loadUserByUsername 함수가 실행.
//그러므로 상속을 UserDetailsService로 받아야한다.
@Service
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    // 시큐리티 session(내부 Authentication(내부 UserDetails)
    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 인자로 받는 username 과 loginForm에 있는 input타입 이름이 반드시 같아야함.(주의)
        // 만일 username2 로 했을경우 동작은 하겠지만, 값 매칭이 안되므로 동작하지않는다.
        // 또는 SecurityConfig에서 .usernameParameter() 메서드를 사용함으로써 특정한 name 을 username처럼 변경하여 사용할 수 있다.

        User userEntity = userRepository.findByUsername(username);
        if(userEntity != null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
