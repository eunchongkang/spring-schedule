package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {

    private String content;
    private String username;
}
