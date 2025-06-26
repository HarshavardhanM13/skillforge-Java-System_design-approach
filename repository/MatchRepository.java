package com.SkillForge.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SkillForge.modal.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    // You can add custom methods here if needed
}
