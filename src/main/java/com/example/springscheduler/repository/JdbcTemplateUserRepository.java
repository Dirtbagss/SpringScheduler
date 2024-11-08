package com.example.springscheduler.repository;

import com.example.springscheduler.dto.ScheduleResponseDto;
import com.example.springscheduler.dto.UserResponseDto;
import com.example.springscheduler.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateUserRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public UserResponseDto saveUser(User user) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("userId");

        LocalDateTime currentDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentDateTime);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", user.getUserId());
        parameters.put("userName", user.getUserName());
        parameters.put("email", user.getEmail());
        parameters.put("update_date", user.getUpdate_date());
        parameters.put("reg_date", timestamp);


        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new UserResponseDto(key.longValue(), user.getUserName(), user.getEmail(),timestamp,timestamp);

    }

    @Override
    public List<ScheduleResponseDto> findScheduleByUserId(Long userId) {

            return jdbcTemplate.query("SELECT * FROM SCHEDULE WHERE userId = ?", scheduleRowMapper(), userId);

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

}
