package spring.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String username;

    public Comment(String content, String username) {
        this.content = content;
        this.username = username;
    }

    public void update(String content, String username) {
        this.content = content;
        this.username = username;
    }

    @ManyToOne
    @JoinColumn(name = "Schedule_ID")
    private Schedule schedule;

}
