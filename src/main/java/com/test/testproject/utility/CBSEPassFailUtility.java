package com.test.testproject.utility;

public class CBSEPassFailUtility implements IUtility{



    @Override
    public String IsStudentPass(int totalMarks) {
        if(totalMarks > 75)
        {
            return  "Pass";
        }
        else
        {
            return  "Failed";
        }
    }
}
