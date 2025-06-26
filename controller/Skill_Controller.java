package com.SkillForge.controller;

import com.SkillForge.modal.*;
import com.SkillForge.repository.*;
import com.SkillForge.service.SkillService;
import com.SkillForge.DTO.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class Skill_Controller {
	
	private final SkillsRepo courseRepository;
    private final  ReqForLearnRepository reqForLearnRepo;
    private final SkillService skillService;
    

    public Skill_Controller(SkillsRepo courseRepository, ReqForLearnRepository reqForLearnRepo,SkillService skillService) {
		this.courseRepository = courseRepository;
		this.reqForLearnRepo = reqForLearnRepo;
		this.skillService = skillService;
	}

	

    @GetMapping
    public List<Skills> getAllCourses() {
        return courseRepository.findAll();
    }
    
    @GetMapping("/requestedSkills")
    public List<ReqSkillLearnerShow> requestedSkills(HttpSession session){
    	Learner learner = (Learner) session.getAttribute("learner");
    	int learner_Id = learner.getLearnerId();
    	System.out.println(learner_Id);
    	List<ReqSkillLearnerShow> result = new ArrayList<>();
    	List<ReqForLearn> requestedSkills = skillService.getLearnerRequestedSkills(learner_Id);
    	for(ReqForLearn obj : requestedSkills) {
    		Skills skill = obj.getSkills();
    		String skillName = skill.getSkillName();
    		String TypeOfNeed = obj.getTypeOfNeed();
    		result.add(new ReqSkillLearnerShow(skillName,TypeOfNeed));
    		//System.out.println(result.getLast().	getSkillName());
    	}
    	return result;
    }
    
    @PostMapping("/createLearning")
    public ResponseEntity<?> createLearningRequest(@RequestBody Integer skillId, HttpSession session) {
        Learner learner = (Learner) session.getAttribute("learner");

        if (learner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(Map.of("error", "Learner is not authenticated"));
        }

        Optional<Skills> optionalSkills = courseRepository.findById(skillId);

        if (!optionalSkills.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(Map.of("error", "Skill not found"));
        }
        
        if(skillService.isCourseAlreadyPending(learner.getLearnerId())) {
        	return ResponseEntity.ok(Map.of("Already",true,"message","Already Course is Pending"));
        }
        Skills skills = optionalSkills.get();
        String typeOfNeed = "doubt";

        ReqForLearn reqForLearn = new ReqForLearn();
        reqForLearn.setTypeOfNeed(typeOfNeed);
        reqForLearn.setLearner(learner);
        reqForLearn.setSkills(skills);

        reqForLearnRepo.save(reqForLearn);

        return ResponseEntity.ok(Map.of("success", true, "message", "Learning request created successfully"));
    }


}
