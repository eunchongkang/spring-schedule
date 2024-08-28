package spring.schedulejpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.schedulejpa.dto.*;
import spring.schedulejpa.entity.Schedule;
import spring.schedulejpa.repository.CommentRepository;
import spring.schedulejpa.repository.ScheduleRepository;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public ScheduleSaveRsponseDto saveSchedule(ScheduleSaveRequestDto ScheduleSaveRequestDto) {
        Schedule schedule = new Schedule(
                ScheduleSaveRequestDto.getUserid(),
                ScheduleSaveRequestDto.getTitle(),
                ScheduleSaveRequestDto.getContent()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleSaveRsponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getUserid(),
                savedSchedule.getContent(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NoSuchElementException("id가 존재하지 않습니다."));
        return new ScheduleDetailResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getUserid(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt(),
                schedule.getComments()
        );
    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long ScheduleId, ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
        Schedule schedule = scheduleRepository.findById(ScheduleId).orElseThrow(() -> new NoSuchElementException("id가 존재하지 않습니다."));

        schedule.update(
                scheduleUpdateRequestDto.getUserid(),
                scheduleUpdateRequestDto.getTitle(),
                scheduleUpdateRequestDto.getContent()
        );
        return new ScheduleUpdateResponseDto(
                schedule.getId(),
                schedule.getUserid(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }


    public Page<ScheduleDetailResponseDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Schedule> schedules = scheduleRepository.findAllByOrderByModifiedAtDesc(pageable);

        return schedules.map(schedule -> new ScheduleDetailResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getUserid(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt(),
                schedule.getComments()
        ));
    }
}


