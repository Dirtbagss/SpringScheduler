package com.example.springscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private String content;
    private String writer;

    public Schedule(String content, String writer) {

        this.content = content;
        this.writer = writer;
    }


    public void update(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }


}
