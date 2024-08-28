package spring.schedulejpa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleDetailResponseDto {

    private final Long id;
    private final String title;
    private final String user;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleDetailResponseDto(Long id, String title, String user,
                                     String content, LocalDateTime createdAt, LocalDateTime modifiedAt, int size) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
