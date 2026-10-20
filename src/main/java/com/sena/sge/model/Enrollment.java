package com.sena.sge.model;

import java.time.LocalDate;

public class Enrollment {

    private Long enrollmentId;
    private LocalDate enrollmentDate;
    private String status;
    
    // Asociación con Estudiante y Curso
    private Student student;
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Long enrollmentId, LocalDate enrollmentDate, String status, Student student, Course course) {
        this.enrollmentId = enrollmentId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.student = student;
        this.course = course;
    }

    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
