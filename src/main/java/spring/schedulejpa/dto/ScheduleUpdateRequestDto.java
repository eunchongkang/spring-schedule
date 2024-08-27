package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private String user;
    private String title;
    private String content;
}
