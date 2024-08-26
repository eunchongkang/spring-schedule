package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {
    private final long id;
    private final String user;
    private final String title;
    private final String content;

    public ScheduleUpdateResponseDto(long id, String user, String title, String content) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
    }

}
