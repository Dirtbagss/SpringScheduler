package com.example.springscheduler.service;

import com.example.springscheduler.dto.ScheduleRequestDto;
import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.entity.Schedule;
import com.example.springscheduler.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {this.scheduleRepository = scheduleRepository;}

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getScheduleId(), requestDto.getWriter(),requestDto.getContent());

        return scheduleRepository.saveSchedule(schedule);

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        return scheduleRepository.findAllSchedules();
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long scheduleId) {

        Schedule schedule = scheduleRepository.findScheduleByScheduleIdByIdOrElseThrow(scheduleId);

        return new ScheduleResponseDto(schedule);
    }


    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long scheduleId, String writer, String content) {

        if (writer == null || content == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "작성자와 내용의 값이 없습니다.");

        }

        int updateRow = scheduleRepository.updateSchedule(scheduleId, writer, content);

        if (updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "수정되지 않았습니다.");
        }

        Schedule schedule = scheduleRepository.findScheduleByScheduleIdByIdOrElseThrow(scheduleId);

        return new ScheduleResponseDto(schedule);
    }
        @Override
        public void deleteSchedule(Long scheduleId){

            int deleteRow = scheduleRepository.deleteSchedule(scheduleId);

            if(deleteRow == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,scheduleId +"가 존재하지 않습니다.");
            }
        }

    }































