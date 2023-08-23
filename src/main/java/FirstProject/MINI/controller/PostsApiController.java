package FirstProject.MINI.controller;


import FirstProject.MINI.controller.dto.PostsResponseDto;
import FirstProject.MINI.controller.dto.PostsSaveRequestDto;
import FirstProject.MINI.controller.dto.PostsUpdateRequestDto;
import FirstProject.MINI.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestParam("title") String title,
                     @RequestParam("author") String author,
                     @RequestParam("content") String content){

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }


}
