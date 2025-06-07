package com.test.testproject.services;

import com.test.testproject.dto.StudentDto;
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

        return  _studentRepository.Studentdata().stream()
                .filter(std -> std.stdId == _stdId).findAny().get();

    }

    public StudentDto GetStudentForPassNFail(int _stdId)
    {
        StudentDto stdDto = new StudentDto();

        Student std1 = _studentRepository.Studentdata().stream()
                .filter(std -> std.stdId == _stdId).findAny().get();

        if(std1.totalMarks > 75)
        {
            stdDto.IsStudentPass = "Pass";
        }
        else
        {
            stdDto.IsStudentPass = "Failed";
        }

        stdDto.stdName = std1.stdName;
        stdDto.stdClass = std1.stdClass;

        return  stdDto;
    }

    public List<Student> AddStudent(Student std)
    {
        List<Student> existingStdList =  _studentRepository.Studentdata();
        existingStdList.add(std);

        return  existingStdList;

    }

    public Student UpdatedStudent(Student updatedStd)
    {
        Student existingStd = _studentRepository.Studentdata().stream()
                .filter(std -> std.stdId == updatedStd.stdId).findAny().get();

        existingStd.totalMarks = updatedStd.totalMarks;

        return  existingStd;

    }
}

