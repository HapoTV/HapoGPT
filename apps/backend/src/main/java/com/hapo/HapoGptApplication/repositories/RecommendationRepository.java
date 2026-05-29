package com.hapo.HapoGptApplication.repositories;

import com.hapo.HapoGptApplication.entities.Recommendation;
import com.hapo.HapoGptApplication.entities.RecommendationType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, UUID> {
    List<Recommendation> findByUserIdOrderByCreatedAtDesc(UUID userId);

    List<Recommendation> findByTypeOrderByCreatedAtDesc(RecommendationType type);
}
