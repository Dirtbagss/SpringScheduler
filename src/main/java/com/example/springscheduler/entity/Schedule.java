package com.example.springscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long schedule;
    private String userId;
    private String password;
    private Date reg_date;
    private String content;
    private Date update_date;
    private String writer;

    public Schedule(String userId, String password, String content, String writer) {
        this.userId = userId;
        this.password = password;
        this.content = content;
        this.writer = writer;
    }


    public void update(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    public void update(String content) {
        this.content = content;
    }


}
