package com.example.springscheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String userName;
    private String email;
    private Timestamp reg_date;
    private Timestamp update_date;
}
