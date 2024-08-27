package spring.schedulejpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String content;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long scheduleid;

    public CommentSaveResponseDto(Long id, String content, String username,
                                  LocalDateTime createdAt, LocalDateTime modifiedAt,Long scheduleid ) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.scheduleid = scheduleid;
    }

}
