package FirstProject.MINI.controller;


import FirstProject.MINI.repository.User;
import FirstProject.MINI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        try{
            //아이디 조회
            if (userRepository.findByUserId(userid) != null) {
                //만약 조회한 값이 null이 아니라면
                String passwordByUserId = userRepository.findPasswordByUserId(userid);
                //아이디에 기반하여 비밀번호를 조회.
                if(passwordByUserId.equals(password)){
                    //비밀번호가 입력한 것과 같다면
                }
            }

            //아이디 조회후 그 아이디에 해당하는 비밀번호조회.
        }catch (){
            //아이디가 존재하지 않을경우의 예외처리
            //비밀번호가 맞지 않을경우의 예외처리
        }

        return "login.html";
    }


}
