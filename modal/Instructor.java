package com.SkillForge.modal;
import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Instructor_Id;

    @Column(name = "Instructor_Name", nullable = false)
    private String Instructor_Name;

    @Column(name = "Instructor_Rating", nullable = false)
    private int Instructor_Rating = 0;

    @Column(name = "Instructor_Skills")
    private String Instructor_Skills;

    // Constructors
    public Instructor() {}

    public Instructor(String instructorName, int instructorRating, String instructorSkills) {
        this.Instructor_Name = instructorName;
        this.Instructor_Rating = instructorRating;
        this.Instructor_Skills = instructorSkills;
    }

    // Getters and Setters
    public int getInstructorId() {
        return Instructor_Id;
    }

    public void setInstructorId(int instructorId) {
        this.Instructor_Id = instructorId;
    }

    public String getInstructorName() {
        return Instructor_Name;
    }

    public void setInstructorName(String instructorName) {
        this.Instructor_Name = instructorName;
    }

    public int getInstructorRating() {
        return Instructor_Rating;
    }

    public void setInstructorRating(int instructorRating) {
        this.Instructor_Rating = instructorRating;
    }

    public String getInstructorSkills() {
        return Instructor_Skills;
    }

    public void setInstructorSkills(String instructorSkills) {
        this.Instructor_Skills = instructorSkills;
    }
}
