package spring.schedulejpa.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.schedulejpa.dto.*;
import spring.schedulejpa.entity.Schedule;
import spring.schedulejpa.service.ScheduleService;


@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public ScheduleSaveRsponseDto saveSchedule(@RequestBody ScheduleSaveRequestDto scheduleSaveRequestDto) {
        return scheduleService.saveSchedule(scheduleSaveRequestDto);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ScheduleDetailResponseDto getSchedule(@PathVariable Long scheduleId) {
        return scheduleService.getSchedule(scheduleId);
    }

    @PutMapping("/schedule/{scheduleId}")
    public ScheduleUpdateResponseDto updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto scheduleUpdateRequestDto ){
        return scheduleService.updateSchedule(scheduleId, scheduleUpdateRequestDto);
    }

    }


