package spring.schedulejpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String title;
    private String cotents;

public Schedule(String user, String title, String cotents) {
    this.user = user;
    this.title = title;
    this.cotents = cotents;

}


}
