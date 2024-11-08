package com.example.springscheduler.controller;


import com.example.springscheduler.dto.ScheduleRequestDto;
import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.dto.UserRequestDto;
import com.example.springscheduler.dto.UserResponseDto;
import com.example.springscheduler.service.ScheduleService;
import com.example.springscheduler.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/{userId}")
    public List<ScheduleResponseDto> findScheduleByUserId(@PathVariable Long userId) {

        return userService.findScheduleByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {

        return new ResponseEntity<>(userService.saveUser(requestDto), HttpStatus.CREATED);
    }


}
