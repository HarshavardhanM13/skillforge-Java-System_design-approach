package com.SkillForge.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SkillForge.modal.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    // You can add custom methods here if needed later
}
