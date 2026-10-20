package com.sena.sge.model;

public class Course {
    
    private Long courseId;
    private String courseName;
    private String description;
    private Integer credits;
    
    // Asociación POO: Un curso tiene un profesor (Mapea la FK teacher_id)
    private Teacher teacher; 

    public Course() {
    }

    public Course(Long courseId, String courseName, String description, Integer credits, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.teacher = teacher;
    }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
}
