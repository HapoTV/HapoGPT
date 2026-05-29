package com.hapo.HapoGptApplication.controllers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public Map<String, Object> health() {
        return Map.of(
                "status", "UP",
                "service", "hapo-gpt-backend",
                "timestamp", Instant.now().toString()
        );
    }

    @GetMapping("/database")
    public Map<String, Object> databaseHealth() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);

            return Map.of(
                    "status", result != null && result == 1 ? "UP" : "DOWN",
                    "database", "supabase-postgresql",
                    "connected", result != null && result == 1,
                    "timestamp", Instant.now().toString()
            );
        } catch (Exception exception) {
            return Map.of(
                    "status", "DOWN",
                    "database", "supabase-postgresql",
                    "connected", false,
                    "error", exception.getMessage(),
                    "cause", getRootCauseMessage(exception),
                    "timestamp", Instant.now().toString()
            );
        }
    }

    private String getRootCauseMessage(Throwable throwable) {
        Throwable rootCause = throwable;

        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }

        return rootCause.getMessage();
    }
}
