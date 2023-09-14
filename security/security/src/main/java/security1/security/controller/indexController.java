package security1.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import security1.security.config.auth.PrincipalDetails;
import security1.security.model.User;
import security1.security.repository.UserRepository;

@Controller //View 리턴.
@Slf4j
public class indexController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/oauth/login")
    public @ResponseBody String loginOAuthTest(Authentication authentication
            ,@AuthenticationPrincipal OAuth2User oauth){ //DI(의존성 주입)

        log.info("/test/login =====================");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        log.info("authentication :" + oAuth2User.getAttributes());

        log.info("oauth2User : "+oauth.getAttributes());

        return "OAuth 세션 정보 확인하기";
    }
    @GetMapping("/test/login")
    public @ResponseBody String loginTest(Authentication authentication,
                                          @AuthenticationPrincipal PrincipalDetails userDetails){ //DI(의존성 주입)
        log.info("/test/login =====================");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        // UserDetails로 의존성 주입받아서 principalDetails로 다운캐스팅을 해야하나, principalDetails에서
        // UserDetails를 상속받고 있기때문에 PrincipalDetails로 사용가능하다.
        log.info("authentication :" + principalDetails.getUsername());

        log.info("userDetails : "+userDetails.getUsername());
        return "세션 정보 확인하기";
    }
    //정리하자면 스프링 시큐리티는 자기만의 session을 가지고있다.(시큐리티가 관리하는 별도의 세션)
    //이 세션에 들어갈수있는 객체 타입은 Authentication 객체밖에없다.
    //여기에 들어간 객체는 필요할때 Controller단에서 필요할때 DI(의존성 주입)을 받을수있다.
    //이 Authentication 에 포함될수있는 두가지 타입이있는데, 1 - UserDetails 2 - OAuth2User
    //일반 로그인 -> userDetails 타입. 페이스북,구글로그인과 같은 OAuth 로그인 -> OAuth2User 타입
    //처리를 여러번 해줘야하니까 불편하다. 그러므로 PrincipalDetails class를 만든뒤 거기에
    //UserDetails 와 OAuth2User를 상속받아서 구현하면 어떤경우에도 PrincipalDetails를 사용하면된다.

    @GetMapping({"/",""})
    public String index(){
        log.info("??");
        return "index";
    }

    //일반 로그인을 해도 PrincipalDetails 객체
    //OAuth2 로그인을 해도 PrincipalDetails 객체
    @GetMapping("/user")
    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        log.info("principalDetails : "+principalDetails.getUser());
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }
    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    @GetMapping("/loginForm")
    public String login(){
        //-SecurityConfig 파일 생성 후 스프링 Security가 자신의 login 화면으로 낚아채지않음
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }
    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/loginForm";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "개인정보";
    }


}
