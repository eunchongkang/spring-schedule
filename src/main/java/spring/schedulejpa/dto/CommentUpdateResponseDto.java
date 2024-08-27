package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {

    private final Long id;
    private final String comment;
    private final String username;

    public CommentUpdateResponseDto(Long id, String comment, String username) {
        this.id = id;
        this.comment = comment;
        this.username = username;
    }
}
