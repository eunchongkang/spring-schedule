package spring.schedulejpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentAllResponseDto {

    private final Long id;
    private final String comment;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentAllResponseDto(Long id, String comment, String username,
                                 LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.comment = comment;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
