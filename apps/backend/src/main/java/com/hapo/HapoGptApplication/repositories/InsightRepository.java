package com.hapo.HapoGptApplication.repositories;

import com.hapo.HapoGptApplication.entities.Insight;
import com.hapo.HapoGptApplication.entities.InsightCategory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsightRepository extends JpaRepository<Insight, UUID> {
    List<Insight> findByUserIdOrderByCreatedAtDesc(UUID userId);

    List<Insight> findByCategoryOrderByCreatedAtDesc(InsightCategory category);
}
