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
                ScheduleSaveRequestDto.getUser(),
                ScheduleSaveRequestDto.getTitle(),
                ScheduleSaveRequestDto.getContent()
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

    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NoSuchElementException("id가 존재하지 않습니다."));
        return new ScheduleDetailResponseDto(
                schedule.getId(),
                schedule.getUser(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt(),
                schedule.getComments().size());
    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long ScheduleId, ScheduleUpdateRequestDto scheduleUpdateRequestDto) {
        Schedule schedule = scheduleRepository.findById(ScheduleId).orElseThrow(() -> new NoSuchElementException("id가 존재하지 않습니다."));

        schedule.update(
                scheduleUpdateRequestDto.getUser(),
                scheduleUpdateRequestDto.getTitle(),
                scheduleUpdateRequestDto.getContent()
        );
        return new ScheduleUpdateResponseDto(
                schedule.getId(),
                schedule.getUser(),
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
                schedule.getUser(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt(),
                schedule.getComments().size()
        ));
    }
}
//    public SchedulePageResponseDto getPage(Pageable pageable){
//        Page<Schedule> schedulepage = scheduleRepository.findAll(pageable);
//
//        List<SchedulePageResponseDto> dtoList = new ArrayList<>();
//
//        for (Schedule schedule : schedulepage.getContent()) {
//            int commentCount = commentRepository.countByScheduledId(schedule.getId());
//            SchedulePageResponseDto dto = new SchedulePageResponseDto(
//                    schedule.getId(),
//                    schedule.getTitle(),
//                    schedule.getContent(),
//                    schedule.getModifiedAt(),
//                    schedule.getCreatedAt(),
//                    schedule.getUser(),
//                    commentCount
//
//            );
//            dtoList.add(dto);
//    }
//        return new SchedulePageResponseDto(dtoList, schedulePage.getNumber(), schedulePage.getSize(), schedulePage.getTotalElements());
//    }

