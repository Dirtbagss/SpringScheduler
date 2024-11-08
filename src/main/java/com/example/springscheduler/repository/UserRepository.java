package com.example.springscheduler.repository;


import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.dto.UserResponseDto;
import com.example.springscheduler.entity.User;

import java.util.List;

public interface UserRepository {

    UserResponseDto saveUser(User user);

    List<ScheduleResponseDto> findScheduleByUserId(Long userId);
}
