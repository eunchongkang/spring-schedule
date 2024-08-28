package spring.schedulejpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userid;
    private String title;
    private String content;

public Schedule(Long userid, String title, String content) {
    this.userid = userid;
    this.title = title;
    this.content = content;
}

public void update(Long userid, String title, String content) {
    this.userid = userid;
    this.title = title;
    this.content = content;
}

@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();



}
