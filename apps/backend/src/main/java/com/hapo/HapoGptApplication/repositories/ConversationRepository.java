package com.hapo.HapoGptApplication.repositories;

import com.hapo.HapoGptApplication.entities.Conversation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, UUID> {
    List<Conversation> findByUserIdOrderByCreatedAtDesc(UUID userId);
}
