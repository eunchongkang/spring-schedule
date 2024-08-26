package spring.schedulejpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String title;
    private String content;

public Schedule(String user, String title, String content) {
    this.user = user;
    this.title = title;
    this.content = content;
}

public void update(String user, String title, String content) {
    this.user = user;
    this.title = title;
    this.content = content;
}

}
