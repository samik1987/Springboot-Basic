package com.test.testproject.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class StudentDto {

    public StudentDto() {
    }

    public StudentDto(int studentId, int studentRoll, String studentName, String studentClass,String isStudentPass) {
        this.studentId = studentId;
        this.isStudentPass = isStudentPass;
        this.studentRoll = studentRoll;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }

    public  int studentId;
    public  int studentRoll;
    public  String studentName;
    public  String studentClass;
    public  String isStudentPass;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getIsStudentPass() {
        return isStudentPass;
    }

    public void setIsStudentPass(String isStudentPass) {
        this.isStudentPass = isStudentPass;
    }
}
