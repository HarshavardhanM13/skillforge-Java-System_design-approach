package com.SkillForge.repository;

import com.SkillForge.modal.Learner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer> {
    // You can add custom query methods here later if needed
	
	Optional<Learner> findByusername(String userName);
}
