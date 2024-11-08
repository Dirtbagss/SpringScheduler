package com.example.springscheduler.repository;

import com.example.springscheduler.dto.ScheduleRequestDto;
import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

        private JdbcTemplate jdbcTemplate;

        public JdbcTemplateScheduleRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

        @Override
        public ScheduleResponseDto saveSchedule(Schedule schedule) {

            SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
            jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("scheduleId");

            LocalDateTime currentDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(currentDateTime);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("userId", schedule.getUserId());
            parameters.put("password", schedule.getPassword());
            parameters.put("writer", schedule.getWriter());
            parameters.put("content", schedule.getContent());
            parameters.put("update_date", timestamp);


            Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

            return new ScheduleResponseDto(key.longValue(), schedule.getUserId(), schedule.getPassword(), schedule.getWriter(), schedule.getContent(),timestamp);

        }

        @Override
        public List<ScheduleResponseDto> findAllSchedules() { return jdbcTemplate.query("SELECT * FROM SCHEDULE ORDER BY UPDATE_DATE DESC", scheduleRowMapper());}


        @Override
        public Schedule  findScheduleByScheduleIdByIdOrElseThrow(Long scheduleId){
            List<Schedule> result = jdbcTemplate.query("SELECT * FROM SCHEDULE WHERE scheduleId = ?", scheduleRowMapperV2(), scheduleId);

            return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, scheduleId + "가 존재하지 않습니다."));
        }

        @Override
        public int updateSchedule(Long scheduleId, String writer, String content) {
            return jdbcTemplate.update("UPDATE SCHEDULE SET writer = ?, content = ? WHERE scheduleId = ?", writer, content, scheduleId);
        }

        @Override
        public int updateWriter(Long scheduleId, String writer) {
            return jdbcTemplate.update("UPDATE SCHEDULE SET writer = ? WHERE scheduleId = ?", writer, scheduleId);
        }

    @Override
    public int deleteSchedule(Long scheduleId) {
        return jdbcTemplate.update("delete from SCHEDULE where scheduleId = ?", scheduleId);
    }






    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("scheduleId"),
                        rs.getLong("userId"),
                        rs.getString("password"),
                        rs.getString("writer"),
                        rs.getString("content"),
                        rs.getTimestamp("update_date")
                );
            }

        };
    }

    private RowMapper<Schedule> scheduleRowMapperV2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("scheduleId"),
                        rs.getLong("userId"),
                        rs.getString("password"),
                        rs.getString("writer"),
                        rs.getString("content"),
                        rs.getTimestamp("update_date")
                );
            }

        };
    }
}
