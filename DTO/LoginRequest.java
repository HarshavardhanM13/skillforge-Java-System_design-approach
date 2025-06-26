package com.SkillForge.DTO;



public class LoginRequest {
    private String learnerName;
    private String learnerPassword;

    // Default constructor (required for JSON deserialization)
    public LoginRequest() {}

    // Getters and setters
    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public String getLearnerPassword() {
        return learnerPassword;
    }

    public void setLearnerPassword(String learnerPassword) {
        this.learnerPassword = learnerPassword;
    }
}
