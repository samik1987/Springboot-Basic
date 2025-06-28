package com.test.testproject.utility;

public class ICSEPassFailUtility implements IUtility{



    @Override
    public String IsStudentPass(int totalMarks) {
        if(totalMarks > 80)
        {
            return  "Pass";
        }
        else
        {
            return  "Failed";
        }
    }
}
