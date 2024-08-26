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

    @PostMapping("/scheudle")
    public ScheduleSaveRsponseDto saveSchedule(@RequestBody ScheduleSaveRsquestDto scheduleSaveRsquestDto) {
        return scheduleService.saveSchedule(scheduleSaveRsquestDto);
    }

    @GetMapping("/scheudle/{scehduleId}")
    public ScheduleDetailResponseDto getSchedule(@PathVariable Long scehduleId) {
        return scheduleService.getSchedule(scehduleId);
    }

    @PutMapping("/schedule/{scheduleId}")
    public ScheduleUpdateResponseDto updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequseDto scheduleUpdateRequseDto ){
        return scheduleService.updateSchedule(scheduleId, scheduleUpdateRequseDto);
    }

    }


