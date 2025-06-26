package com.SkillForge.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.SkillForge.modal.Instructor;
import com.SkillForge.modal.ReqForLearn;
import com.SkillForge.modal.Skills;
import com.SkillForge.repository.InstructorRepository;
import com.SkillForge.repository.ReqForLearnRepository;
import com.SkillForge.repository.SkillsRepo;

@Service
public class InstructorService {

	private InstructorRepository instructorRepo;
	private ReqForLearnRepository reqForlearnrepo;
	private SkillsRepo skillsRepo;
	
	
	
	public InstructorService(InstructorRepository instructorRepo, ReqForLearnRepository reqForlearnrepo,
			SkillsRepo skillsRepo) {
		super();
		this.instructorRepo = instructorRepo;
		this.reqForlearnrepo = reqForlearnrepo;
		this.skillsRepo = skillsRepo;
	}

	
	
	
	
	

	public Instructor getInstructorById(int id) {
		Optional<Instructor> obj = instructorRepo.findById(id);
		System.out.println(obj.get().getInstructorName());
		return obj.get();
	}

	public List<ReqForLearn> getRequestsbyUserSkills(int id) {
		List<ReqForLearn> requests = getAll(); 
		List<Integer> InstructorSkillId = getInstructorSkillIdList(id);
		List<ReqForLearn> result = new ArrayList<>();
		Set<Integer> hs = new HashSet<>(InstructorSkillId);
		for(ReqForLearn obj  : requests) {
			if(hs.contains(obj.getSkills().getSkillId())) {
				result.add(obj);
			}
		}
		return result;
		
	}
	
	public List<Integer> getInstructorSkillIdList(int id){
		String[] instructorSkills = getInstructorSkills(id).split(",");
		List<Integer> instructorIDs = new ArrayList<>();

		// Convert skill names to a set for fast lookup
		Set<String> skillNamesSet = new HashSet<>();
		for (String skillName : instructorSkills) {
		    skillNamesSet.add(skillName.trim());  // trim to avoid space issues
		}

		List<Skills> allSkills = skillsRepo.findAll();

		for (Skills skill : allSkills) {
		    if (skillNamesSet.contains(skill.getSkillName())) {
		        instructorIDs.add(skill.getSkillId());  // Assuming Skills has instructorId
		    }
		}
		return instructorIDs;

	}
	public List<ReqForLearn> getAll(){
		return  reqForlearnrepo.findAll();
	}
	
	public String getInstructorSkills(int id) {
		Optional<Instructor> obj = instructorRepo.findById(id);
		return obj.get().getInstructorSkills();
	}

}
