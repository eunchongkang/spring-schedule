package spring.schedulejpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.schedulejpa.entity.Comment;
import spring.schedulejpa.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>  {
//    Page<Schedule> findAll(Pageable pageable);
    Page<Schedule> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
