package spring.schedulejpa.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {

    private String title;
    private String user;
    private String content;

}
