package com.SkillForge.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "learner")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Learner_Id")
    private int learnerId;

    @Column(name = "Learner_Name", length = 100)
    private String learnerName;

    @Column(name = "Learner_Obedience")
    private int learnerObedience = 0; // Default value
    
   	@Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    // Constructors
    public Learner() {}

    // Getters and setters
    public int getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public int getLearnerObedience() {
        return learnerObedience;
    }

    public void setLearnerObedience(int learnerObedience) {
        this.learnerObedience = learnerObedience;
    }
    
    public String getUser_name() {
		return username;
	}

	public void setUser_name(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
