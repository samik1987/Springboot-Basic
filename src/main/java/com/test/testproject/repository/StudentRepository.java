package com.test.testproject.repository;

import com.test.testproject.models.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public List<Student> Studentdata()
    {
        List<Student> stdList = new ArrayList<Student>();

        Student std1 =  new Student(1,12,"Dheeraj","Five",89);
        Student std2 =  new Student(2,15,"Samik","Six",60);
        Student std3 =  new Student(3,18,"Amit","Six",78);

        stdList.add(std1);
        stdList.add(std2);
        stdList.add(std3);

        return  stdList;
    }
}
