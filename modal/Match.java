package com.SkillForge.modal;
import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    @Column(name = "Instructor_Id", nullable = false)
    private int instructorId;

    @Column(name = "Req_Id", nullable = false)
    private int reqId;

    // Constructors
    public Match() {}

    public Match(int instructorId, int reqId) {
        this.instructorId = instructorId;
        this.reqId = reqId;
    }

    // Getters and Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }
}
