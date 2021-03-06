package com.sj.hosp.service;

import com.sj.hosp.domain.post.Post;
import com.sj.hosp.domain.post.PostRepository;
import com.sj.hosp.web.dto.PostResponseDto;
import com.sj.hosp.web.dto.PostSaveRequestDto;
import com.sj.hosp.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));

        post.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다."));

        return new PostResponseDto(entity);
    }
}
