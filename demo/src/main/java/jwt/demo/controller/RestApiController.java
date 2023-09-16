package jwt.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RestApiController {

    @GetMapping("/home")
    public String home(){
        log.info("???");
        return "home!!!!!";
    }
}
