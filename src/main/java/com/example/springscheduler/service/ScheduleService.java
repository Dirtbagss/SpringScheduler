package com.example.springscheduler.service;

import com.example.springscheduler.dto.ScheduleRequestDto;
import com.example.springscheduler.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedules();

    ScheduleResponseDto findScheduleById(Long Schedule);

    ScheduleResponseDto updateSchedule(Long Schedule, String writer, String content);

    void deleteSchedule(Long Schedule);


}
