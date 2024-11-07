package com.example.springscheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long scheduleId;
    private Long userId;
    private String password;
    private Date reg_date;
    private String content;
    private Date update_date;
    private String writer;

}
