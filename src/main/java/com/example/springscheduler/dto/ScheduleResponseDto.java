package com.example.springscheduler.dto;

import com.example.springscheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long scheduleId;

    private String content;

    private String writer;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.writer = schedule.getWriter();
        this.content = schedule.getContent();
    }

}
