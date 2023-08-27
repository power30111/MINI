package FirstProject.MINI.controller;


import FirstProject.MINI.controller.dto.PostsResponseDto;
import FirstProject.MINI.controller.dto.PostsSaveRequestDto;
import FirstProject.MINI.controller.dto.PostsUpdateRequestDto;
import FirstProject.MINI.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestParam("title") String title,
                     @RequestParam("author") String author,
                     @RequestParam("content") String content){

        PostsSaveRequestDto requestDto = getRequestDto(title, author, content);
        return postsService.save(requestDto);
    }

    private static PostsSaveRequestDto getRequestDto(String title, String author, String content) {
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
        return requestDto;
    }

    @PostMapping("/api/v1/posts/update/{id}")
    public Long update(@PathVariable Long id,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content){
        PostsUpdateRequestDto requestDto = getUpdateDto(title,content);
        return postsService.update(id, requestDto);
    }

    private static PostsUpdateRequestDto getUpdateDto(String title, String content) {
        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(title)
                .content(content)
                .build();
        return requestDto;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        PostsResponseDto posts = postsService.findById(id);
        return posts;
    }
    @GetMapping("/api/v1/posts/delete/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
