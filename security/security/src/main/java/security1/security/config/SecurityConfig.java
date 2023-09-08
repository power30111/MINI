package security1.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import security1.security.config.oauth.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) //secured 어노테이션 활성화
// securedEnabled = true -> indexController에 info메서드에 간단하게 security 를 걸수있다.(개편한듯)
// prePostEnabled = true -> 마찬가지로 Security 를걸수있는데, 특징으로는 여러 조건을 걸수있다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() //인증만 되면 들어갈수 있는 주소
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")       // /login이라는 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다.
                .defaultSuccessUrl("/")             // -> 그럴경우 Controller에 따로 login관련 매핑을 해줄필요가없다.
                                                    // defaultSuccessUrl -> 원래 가려던 페이지가 있을경우 그 페이지로 이동.
                                                    // 그러나 처음부터 login페이지로 왔을경우 / 주소로 이동.
                .and()
                .oauth2Login()                      //oauth2 Login또한 LoginForm으로 설정
                .loginPage("/loginForm")            //구글 로그인이 완료된 뒤의 후처리가 필요하다. 이 경우 1.코드 받기(인증받은것. 즉 정상적인 구글 사용자)
                .userInfoEndpoint()                 // 2. 액세스토큰받기(사용자의 정보에 대해 접근할 권한을 얻음) 3.사용자 프로필 정보를 가져옴
                .userService(principalOauth2UserService);// 4. 그 정보를 토대로 회원가입을 자동적으로 할수 있도록 할수있음. or 정보가 좀 부족할 경우?
                                                    // --> 추가적인 회원가입 화면을 띄워서 할수도있음 Tip. 구글 로그인이 완료되면 코드를 받는것이 아닌,
                                                    // 액세스 토큰과 사용자의 프로필정보를 한번에 받아온다.

    }
}
