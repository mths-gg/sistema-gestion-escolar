package com.sena.sge.model;

import java.time.LocalDateTime;

public class Teacher {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String specialty;
    private LocalDateTime createdAt;

    public Teacher() {
    }

    public Teacher(Long teacherId, String firstName, String lastName, String email, String specialty, LocalDateTime createdAt) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialty = specialty;
        this.createdAt = createdAt;
    }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
