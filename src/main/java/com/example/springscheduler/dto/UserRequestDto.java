package com.example.springscheduler.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserRequestDto {

    private Long userId;
    private String userName;
    private String email;
    private Timestamp reg_date;
    private Timestamp update_date;
}
