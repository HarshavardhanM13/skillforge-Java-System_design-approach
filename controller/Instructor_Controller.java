package com.SkillForge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SkillForge.modal.Instructor;
import com.SkillForge.modal.ReqForLearn;
import com.SkillForge.repository.ReqForLearnRepository;
import com.SkillForge.service.InstructorService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/instructor")
public class Instructor_Controller {
	
	private InstructorService instructorService;
	
	public Instructor_Controller(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@GetMapping("/instructors_id/{id}")
	public Instructor getInstructorById(@PathVariable int id,HttpSession session) {
		
		Instructor instructor = instructorService.getInstructorById(id);
		session.setAttribute("instructor", instructor);
		
	    return instructor;
	}
	
	@GetMapping("/instructors_Requests")
	public List<ReqForLearn> getLearningRequests(HttpSession session) {
		Instructor ins =(Instructor) session.getAttribute("instructor");
		System.out.println(ins.getInstructorId() + ins.getInstructorName() + ins.getInstructorSkills());
		System.out.println(ins.getInstructorId()+"i am here");
	    return instructorService.getRequestsbyUserSkills(ins.getInstructorId());
	}

}
