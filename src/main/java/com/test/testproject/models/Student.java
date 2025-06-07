package com.test.testproject.models;


public class Student {

    public  int stdId;
    public  int stdRoll;
    public  String stdName;
    public  String stdClass;
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
