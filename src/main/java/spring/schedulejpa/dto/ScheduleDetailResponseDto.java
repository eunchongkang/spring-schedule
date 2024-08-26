package spring.schedulejpa.dto;

import spring.schedulejpa.entity.Schedule;

import java.time.LocalDateTime;

public class ScheduleDetailResponseDto {

    private final Long id;
    private final String title;
    private final String user;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleDetailResponseDto(Long id, String title, String user,
    String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
