package FirstProject.MINI.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Order")
@Slf4j
public class OrderController {
    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("data","test");
        log.info("model 데이터 삽입");
        return "/test";
    }
    @GetMapping("/{user}/order")
    public String order(@PathVariable String user, Model model){
        //User별 주문내역을 조회하는내용
        return "/order/list";
    }

    @PostMapping("/{user}/order")
    public String userOrder(@PathVariable String user, Model model){
        //유저가 상품을 주문하였을경우   ->
        return "/order";
    }
}
