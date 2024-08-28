package spring.schedulejpa.dto;

import lombok.Getter;
import spring.schedulejpa.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ScheduleSaveRsponseDto {

    private final Long id;
    private final String title;
    private final Long userid;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    public ScheduleSaveRsponseDto(Long id, String title, Long userid, String content,
                                  LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.userid = userid;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
