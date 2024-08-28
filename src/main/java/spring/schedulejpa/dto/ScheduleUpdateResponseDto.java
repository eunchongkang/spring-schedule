package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {
    private final long id;
    private final Long userid;
    private final String title;
    private final String content;

    public ScheduleUpdateResponseDto(long id, Long userid, String title, String content) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.content = content;
    }

}
