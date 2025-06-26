package com.SkillForge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SkillForge.DTO.LoginRequest;
import com.SkillForge.modal.Learner;
import com.SkillForge.service.LoginService;

import jakarta.servlet.http.HttpSession;
import java.util.Map;

@RestController	
@RequestMapping("/auth")
public class LoginController {
	
	private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            // Call your authentication logic here
        	System.out.println(loginRequest.getLearnerName()+" "+loginRequest.getLearnerPassword());
            Learner learner = loginService.authenticate(loginRequest.getLearnerName(), loginRequest.getLearnerPassword());

            if (learner != null) {
            	System.out.println("Session ID: " + session.getId());
                session.setAttribute("learner", learner);
                System.out.println("Learner in session: " + session.getAttribute("learner"));

                return ResponseEntity.ok(Map.of(
                        "message", "Login successful",
                        "ok", true,
                        "success", true,
                        "status", 200
                    ));
                
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                     .body(Map.of("error", "Invalid credentials"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Internal server error"));
        }
    }
}
