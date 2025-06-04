package com.test.testproject.services;

import com.test.testproject.models.Student;
import com.test.testproject.repository.StudentRepository;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdudentService {

    @Autowired
    public StudentRepository _studentRepository;

    public List<Student> GetAllStudent()
    {
        //StudentRepository _studentRepository = new StudentRepository();
        return  _studentRepository.Studentdata();

    }

    public Student GetStudentById(int _stdId)
    {
        //StudentRepository _studentRepository = new StudentRepository();

//        for (Student std in  _studentRepository.Studentdata())
//        {
//
//        }

        return  _studentRepository.Studentdata().stream()
                .filter(std -> std.stdId == _stdId).findAny().get();

    }
}

