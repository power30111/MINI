package FirstProject.MINI.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @GetMapping("/test")

    public String test(Model model){
        model.addAttribute("data","test");
        return "templates/index.html";
    }
}
