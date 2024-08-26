package spring.schedulejpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.schedulejpa.dto.*;
import spring.schedulejpa.entity.Schedule;
import spring.schedulejpa.repository.ScheduleRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveRsponseDto saveSchedule(ScheduleSaveRsquestDto ScheduleSaveRsquestDto) {
        Schedule schedule = new Schedule(
                ScheduleSaveRsquestDto.getUser(),
                ScheduleSaveRsquestDto.getTitle(),
                ScheduleSaveRsquestDto.getUser()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleSaveRsponseDto(
                savedSchedule.getId(),
                savedSchedule.getUser(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }
    public ScheduleDetailResponseDto getSchedule(Long ScheduleId) {
        Schedule schedule = scheduleRepository.findById(ScheduleId).orElseThrow(() -> new NoSuchElementException("id가 존재하지 않습니다."));
        return new ScheduleDetailResponseDto(
                schedule.getId(),
                schedule.getUser(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long ScheduleId, ScheduleUpdateRequseDto scheduleUpdateRequseDto){
        Schedule schedule = scheduleRepository.findById(ScheduleId).orElseThrow(() -> new NoSuchElementException("id가 존재하지 않습니다."));

        schedule.update(
                scheduleUpdateRequseDto.getUser(),
                scheduleUpdateRequseDto.getTitle(),
                scheduleUpdateRequseDto.getContent()
        );
        return new ScheduleUpdateResponseDto(
                schedule.getId(),
                schedule.getUser(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }

}
