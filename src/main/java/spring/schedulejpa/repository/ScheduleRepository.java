package spring.schedulejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.schedulejpa.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>  {
}
