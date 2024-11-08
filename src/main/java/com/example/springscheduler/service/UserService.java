package com.example.springscheduler.service;


import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.dto.UserRequestDto;
import com.example.springscheduler.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto requestDto);

    List<ScheduleResponseDto> findScheduleByUserId(Long userId);
}
