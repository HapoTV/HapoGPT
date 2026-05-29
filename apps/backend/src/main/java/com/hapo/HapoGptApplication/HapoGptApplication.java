package com.hapo.HapoGptApplication;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HapoGptApplication {

    public static void main(String[] args) {
        loadEnvironment();
        SpringApplication.run(HapoGptApplication.class, args);
    }

    private static void loadEnvironment() {
        loadEnvironmentFrom(".");
        loadEnvironmentFrom("apps/backend");
        mapEnvironmentProperty("SPRING_DATASOURCE_URL", "spring.datasource.url");
        mapEnvironmentProperty("SPRING_DATASOURCE_USERNAME", "spring.datasource.username");
        mapEnvironmentProperty("SPRING_DATASOURCE_PASSWORD", "spring.datasource.password");
        mapEnvironmentProperty("SPRING_JPA_HIBERNATE_DDL_AUTO", "spring.jpa.hibernate.ddl-auto");
        mapEnvironmentProperty("SPRING_JPA_SHOW_SQL", "spring.jpa.show-sql");
        mapEnvironmentProperty("JWT_SECRET", "app.jwt.secret");
        mapEnvironmentProperty("JWT_EXPIRATION_MS", "app.jwt.expiration-ms");
        mapEnvironmentProperty("SUPABASE_URL", "app.supabase.url");
        mapEnvironmentProperty("SUPABASE_ANON_KEY", "app.supabase.anon-key");
        mapEnvironmentProperty("SUPABASE_SERVICE_ROLE_KEY", "app.supabase.service-role-key");
        mapEnvironmentProperty("QLOO_API_KEY", "app.qloo.api-key");
        mapEnvironmentProperty("QLOO_BASE_URL", "app.qloo.base-url");
    }

    private static void loadEnvironmentFrom(String directory) {
        Dotenv dotenv = Dotenv.configure()
                .directory(directory)
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(entry -> {
            if (System.getProperty(entry.getKey()) == null && System.getenv(entry.getKey()) == null) {
                System.setProperty(entry.getKey(), entry.getValue());
            }
        });
    }

    private static void mapEnvironmentProperty(String environmentKey, String springPropertyKey) {
        String value = System.getProperty(environmentKey);

        if (value == null || value.isBlank()) {
            value = System.getenv(environmentKey);
        }

        if (value != null && !value.isBlank()) {
            System.setProperty(springPropertyKey, value);
        }
    }
}
