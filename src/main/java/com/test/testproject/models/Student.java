package com.test.testproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "StudentDetails")
public class Student {

    @Id
    @Column(nullable = false, unique = true)
    public  int stdId;
    public  int stdRoll;
    @NotBlank(message = "student name is mandatory")
    @Column(nullable = false, unique = true)
    public  String stdName;
    public  String stdClass;

    @Max(value = 100, message = "marks cannot exceed 100")
    public  int totalMarks;

    public Student(int stdId, int stdRoll, String stdName, String stdClass) {
        this.stdId = stdId;
        this.stdRoll = stdRoll;
        this.stdName = stdName;
        this.stdClass = stdClass;
    }

    public Student(int stdId, int stdRoll, String stdName, String stdClass, int totalMarks) {
        this.stdId = stdId;
        this.stdRoll = stdRoll;
        this.stdName = stdName;
        this.stdClass = stdClass;
        this.totalMarks = totalMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Student() {
    }

    public int getStdId() {
        return stdId;
    }

    public int getStdRoll() {
        return stdRoll;
    }

    public String getStdName() {
        return stdName;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public void setStdRoll(int stdRoll) {
        this.stdRoll = stdRoll;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }
}
