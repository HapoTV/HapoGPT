package com.hapo.HapoGptApplication.repositories;

import com.hapo.HapoGptApplication.entities.Report;
import com.hapo.HapoGptApplication.entities.ReportStatus;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, UUID> {
    List<Report> findByUserIdOrderByCreatedAtDesc(UUID userId);

    List<Report> findByStatusOrderByCreatedAtDesc(ReportStatus status);
}
