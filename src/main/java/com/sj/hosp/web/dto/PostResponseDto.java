package com.sj.hosp.web.dto;

import com.sj.hosp.domain.post.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String titie;
    private String content;
    private String author;

    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.titie = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
