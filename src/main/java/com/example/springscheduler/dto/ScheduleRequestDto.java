package com.example.springscheduler.dto;

import lombok.Getter;

import java.sql.Timestamp;


@Getter
public class ScheduleRequestDto {

    private Long scheduleId;
    private Long userId;
    private String password;
    private String content;
    private String writer;
    private Timestamp update_date;

}
