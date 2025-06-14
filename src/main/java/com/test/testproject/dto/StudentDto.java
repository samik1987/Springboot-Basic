package com.test.testproject.dto;




public class StudentDto {

    public  int stdId;
    public  int stdRoll;
    public  String stdName;
    public  String stdClass;
    public  String IsStudentPass;

    public StudentDto(int stdId, int stdRoll, String stdName, String stdClass, String isStudentPass) {
        this.stdId = stdId;
        this.stdRoll = stdRoll;
        this.stdName = stdName;
        this.stdClass = stdClass;
        IsStudentPass = isStudentPass;
    }

    public StudentDto() {
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

    public String getIsStudentPass() {
        return IsStudentPass;
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

    public void setIsStudentPass(String isStudentPass) {
        IsStudentPass = isStudentPass;
    }
}
