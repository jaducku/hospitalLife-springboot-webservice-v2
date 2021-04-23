package com.sj.hosp.web;

import com.sj.hosp.service.PostService;
import com.sj.hosp.web.dto.PostResponseDto;
import com.sj.hosp.web.dto.PostSaveRequestDto;
import com.sj.hosp.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostApiController {
    private final PostService postService;

    @PostMapping("")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
       return postService.update(id,requestDto);
    }

    @GetMapping("/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }
}
