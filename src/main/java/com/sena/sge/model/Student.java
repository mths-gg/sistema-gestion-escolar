package com.sena.sge.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    
    // Encapsulamiento: Atributos privados
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;

    // Constructor vacío (Requerido por muchos frameworks como Spring Boot)
    public Student() {
    }

    // Constructor con parámetros (Clean Code: Facilita la inyección de datos sin mutabilidad excesiva)
    public Student(Long studentId, String firstName, String lastName, String email, LocalDate dateOfBirth, LocalDateTime createdAt) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
    }

    // Getters y Setters públicos
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
