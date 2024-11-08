package com.example.springscheduler.service;

import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.dto.UserRequestDto;
import com.example.springscheduler.dto.UserResponseDto;
import com.example.springscheduler.entity.User;
import com.example.springscheduler.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public UserResponseDto saveUser(UserRequestDto requestDto) {

        User user = new User(requestDto.getUserId(), requestDto.getUserName(), requestDto.getEmail(), requestDto.getReg_date(),requestDto.getUpdate_date());

        return userRepository.saveUser(user);

    }

    @Override
    public List<ScheduleResponseDto> findScheduleByUserId(Long userId) {

        return userRepository.findScheduleByUserId(userId);
    }

}
