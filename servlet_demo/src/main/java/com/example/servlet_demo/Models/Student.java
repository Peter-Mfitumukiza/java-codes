package com.example.servlet_demo.Models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "firstname", unique = true, nullable = false)
    private String firstName;
    private String lastName;
    private String gender;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<CourseAssignment> courses = new HashSet<>();
    public Student() {
    }
    public Student(Long id) {
        this.id = id;
    }
    public Student(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    public Student(Long id, String firstName, String lastName, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Set<CourseAssignment> getCourses() {
        return courses;
    }
    public void setCourses(Set<CourseAssignment> courses) {
        this.courses = courses;
    }
}
