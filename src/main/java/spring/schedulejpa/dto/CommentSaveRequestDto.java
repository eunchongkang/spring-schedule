package spring.schedulejpa.dto;

import lombok.Getter;
import lombok.Setter;
import spring.schedulejpa.entity.Schedule;


@Getter

public class CommentSaveRequestDto {

    private String content;
    private String username;
    private Long scheduleid;

}
