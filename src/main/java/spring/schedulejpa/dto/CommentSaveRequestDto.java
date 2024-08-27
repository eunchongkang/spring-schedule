package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    private String content;
    private String username;
}
