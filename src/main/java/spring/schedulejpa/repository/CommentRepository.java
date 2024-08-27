package spring.schedulejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.schedulejpa.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByCreatedAtBetweenOrderByModifiedAtDesc(LocalDateTime startTime, LocalDateTime endTime);
}
