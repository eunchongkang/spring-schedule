package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private Long userid;
    private String title;
    private String content;
}
