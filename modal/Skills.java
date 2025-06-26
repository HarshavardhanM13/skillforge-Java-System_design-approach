package com.SkillForge.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Skill_Id")
    private int skillId; //Renamed to skillId to fix your naming conventions

    @Column(nullable = false, name = "Skill_Name")
    private String skillName; //Renamed to skillName to fix your naming conventions

    // Constructors
    public Skills() {}

    public Skills(String skillName) {
        this.skillName = skillName;
    }

    // Getters and setters
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
