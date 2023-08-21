package FirstProject.MINI.controller;


import FirstProject.MINI.domain.User.User;
import FirstProject.MINI.domain.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/User/signup")
    public String JoinUser(){
        return "signup.html";
    }

    @PostMapping("/User/signup")
    public String Register(@RequestParam("userid") String userid,
                         @RequestParam("password") String password,
                         @RequestParam("name") String name){
        User user = new User(userid,password,name);
        userRepository.save(user);
        log.info("회원가입완료");
        log.info("아이디 = "+userid);
        log.info("비밀번호 = "+password);
        log.info("이름 = "+name);
        return "index.html";
    }
    @GetMapping("/User/login")
    public String loginUser(){
        return "login.html";
    }

    @PostMapping("/User/login")
    public String loginUser(@RequestParam("userid") String userid,
                            @RequestParam("password") String password){
        


        return "login.html";
    }


}
