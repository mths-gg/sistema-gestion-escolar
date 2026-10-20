package com.sena.sge.model;

import java.time.LocalDateTime;

public class Grade {

    private Long gradeId;
    private Double gradeValue;
    private String observation;
    private LocalDateTime gradedDate;
    
    // Asociación: Una nota pertenece a una matrícula específica
    private Enrollment enrollment;

    public Grade() {
    }

    public Grade(Long gradeId, Double gradeValue, String observation, LocalDateTime gradedDate, Enrollment enrollment) {
        this.gradeId = gradeId;
        this.gradeValue = gradeValue;
        this.observation = observation;
        this.gradedDate = gradedDate;
        this.enrollment = enrollment;
    }

    public Long getGradeId() { return gradeId; }
    public void setGradeId(Long gradeId) { this.gradeId = gradeId; }

    public Double getGradeValue() { return gradeValue; }
    public void setGradeValue(Double gradeValue) { this.gradeValue = gradeValue; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    public LocalDateTime getGradedDate() { return gradedDate; }
    public void setGradedDate(LocalDateTime gradedDate) { this.gradedDate = gradedDate; }

    public Enrollment getEnrollment() { return enrollment; }
    public void setEnrollment(Enrollment enrollment) { this.enrollment = enrollment; }
}
