package com.example.springscheduler.controller;

import com.example.springscheduler.dto.ScheduleRequestDto;
import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

   private ScheduleController(ScheduleService scheduleService) { this.scheduleService = scheduleService; }


    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {

       return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules(){
       return scheduleService.findAllSchedules();
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long scheduleId) {

       return new ResponseEntity<>(scheduleService.findScheduleById(scheduleId), HttpStatus.OK);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequestDto requestDto
    ){
       return new ResponseEntity<>(scheduleService.updateSchedule(scheduleId, requestDto.getWriter(),requestDto.getContent()), HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {

       scheduleService.deleteSchedule(scheduleId);
       return new ResponseEntity<>(HttpStatus.OK);
    }





}




















