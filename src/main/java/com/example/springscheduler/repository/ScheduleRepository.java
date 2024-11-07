package com.example.springscheduler.repository;

import com.example.springscheduler.dto.ScheduleRequestDto;
import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Optional<Schedule> findScheduleById(Long scheduleId);

    Schedule findScheduleByScheduleIdByIdOrElseThrow(Long scheduleId);

    int updateSchedule(Long scheduleId, String writer, String content);

    int updateWriter(Long scheduleId, String writer);

    int deleteSchedule(Long scheduleId);
}
