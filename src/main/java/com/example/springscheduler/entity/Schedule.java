package com.example.springscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private Long userId;
    private String password;
    private String content;
    private String writer;
    private Timestamp update_date;


    public void update(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }


}
