package spring.schedulejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.schedulejpa.entity.Comment;
import spring.schedulejpa.entity.User;

import java.time.LocalDateTime;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<Comment> findAllByCreatedAtBetweenOrderByModifiedAtDesc
            (LocalDateTime startTime, LocalDateTime endTime);

}
