package security1.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //View 리턴.
@Slf4j
public class indexController {

    @GetMapping({"/",""})
    public String index(){
        log.info("??");
        return "index";
    }
}
