package com.example.springscheduler.dto;

import com.example.springscheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long scheduleId;
    private Long userId;
    private String password;
    private String content;
    private String writer;
    private Timestamp update_date;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.userId = schedule.getUserId();
        this.password = schedule.getPassword();
        this.writer = schedule.getWriter();
        this.content = schedule.getContent();
        this.update_date = schedule.getUpdate_date();


    }

    public ScheduleResponseDto(long scheduleId, Long userId, String password, String writer, String content) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.password = password;
        this.writer = writer;
        this.content = content;

    }
}
