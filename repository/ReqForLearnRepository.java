package com.SkillForge.repository;

import com.SkillForge.modal.ReqForLearn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReqForLearnRepository extends JpaRepository<ReqForLearn, Integer> {

	List<ReqForLearn> findAllByLearner_LearnerId(int learnerId);
	
	boolean existsByLearner_LearnerId(int id);

    // No custom methods needed for basic CRUD operations
}
