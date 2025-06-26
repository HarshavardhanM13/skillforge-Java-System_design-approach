package com.SkillForge.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "Req_for_learn")
public class ReqForLearn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Req_Id")
    private int reqId;

    @Column(name = "TypeOfNeed", length = 50)
    private String typeOfNeed;

	@ManyToOne
    @JoinColumn(name = "Learner_Id", referencedColumnName = "learner_Id")  
    private Learner learner; 

    @ManyToOne
    @JoinColumn(name = "Skill_Id")
    private Skills skills;

    // Constructors
    public ReqForLearn() {}

    public ReqForLearn(String typeOfNeed, Learner learner, Skills skills) {
		super();
		this.typeOfNeed = typeOfNeed;
		this.learner= learner;
		this.skills = skills;
	}

   
	// Getters and setters
    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getTypeOfNeed() {
        return typeOfNeed;
    }

    public void setTypeOfNeed(String typeOfNeed) {
        this.typeOfNeed = typeOfNeed;
    }

    public Learner getLearner() {
        return learner;
    }

    public void setLearner(Learner learner) {
        this.learner = learner;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }
}
