package com.SkillForge.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SkillForge.DTO.UserDetails;

@Controller
public class BasicControllers {

    @GetMapping("/login")
    public String redirectToLogin() {
    	//System.out.println("work");
        return "redirect:/Login.html";
    }
    @GetMapping("/")
    public String OpenDashBoard() {
    	//System.out.println("work");
        return "redirect:/dashboard.html";
    }
    @GetMapping("/load/loadUserProfile")
    public List<UserDetails> LoadUserData(){
    	List<UserDetails> result = new ArrayList<>();
    	return result;
    }
}
