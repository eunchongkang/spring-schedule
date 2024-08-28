package spring.schedulejpa.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @DeleteMapping("/schedule/{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
    }

    @GetMapping("/schedules")
    public Page<ScheduleDetailResponseDto> getSchedules(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size){
                return scheduleService.getSchedules(page, size);
    }


}
//    @GetMapping("/schedules")
//    public Page<SchedulePageResponseDto> getPage(@PageableDefault(size = 10,
//            sort = "modifiedAt", direction = Sort.Direction.DESC) Pageable pageable){
//        return scheduleService.getPage(pageable);
//    }




