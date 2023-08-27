package FirstProject.MINI.controller;


import FirstProject.MINI.controller.dto.PostsResponseDto;
import FirstProject.MINI.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
@Slf4j
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);

        model.addAttribute("dto",dto);
        return "posts-update";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);

        model.addAttribute("dto", dto);
        return "posts";
    }


}
