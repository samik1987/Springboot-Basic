package com.test.testproject.services;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import com.test.testproject.repository.StudentRepository;
import com.test.testproject.utility.IUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ICSEStdudentService {

    @Autowired
    public StudentRepository _studentRepository;


    private final IUtility _utilityObj;

    public ICSEStdudentService(@Qualifier("ICSE-Utility") IUtility utilityObj) {
        this._utilityObj = utilityObj;
    }

    public List<Student> GetAllStudent()
    {
        //StudentRepository _studentRepository = new StudentRepository();
        return  _studentRepository.Studentdata();

    }

    public   Map<String, Long> GetAllStudentByGrouping()
    {
        //StudentRepository _studentRepository = new StudentRepository();
        List<Student> stdList =  _studentRepository.Studentdata();
        List<StudentDto> stdDtoList = new ArrayList<>();

        Map<String, Long> stdgroup =  stdList.stream()
                .map(std ->{
                   return new StudentDto(std.stdId,std.stdRoll,std.stdName,std.stdClass,std.totalMarks> 75 ? "pass" : "fail");
                }).collect(Collectors.groupingBy(st-> st.IsStudentPass, Collectors.counting()));

        return  stdgroup;

    }

    public Student GetStudentById(int _stdId)
    {

        Optional<Student>  sercStd =_studentRepository.Studentdata().stream()
                .filter(std -> std.stdId == _stdId).findAny();

        return  sercStd.orElse(new Student());

    }

    public StudentDto GetStudentForPassNFail(int _stdId)
    {
        StudentDto stdDto = new StudentDto();


        Student std1 = _studentRepository.Studentdata().stream()
                .filter(std -> {

                    if(std.stdId == _stdId)
                        return true;
                    else
                        return false;
                })
                .findAny().get();


        stdDto.IsStudentPass = _utilityObj.IsStudentPass(std1.totalMarks);;


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

    public Student UpdatedStudent(Student updatedStd) throws Exception {

        return  _studentRepository.Studentdata().stream()
                .filter(std -> std.stdId == updatedStd.stdId)
                .map(stud -> {
                    return   new Student(stud.stdId, stud.stdRoll, stud.stdName, stud.stdClass, (stud.totalMarks = updatedStd.totalMarks));
                })
                .findAny()
                //.orElse(null);
                .orElseThrow( ()-> new Exception("Data Not present"));

//        Optional<Student> existingStd = _studentRepository.Studentdata().stream()
//                .filter(std -> std.stdId == updatedStd.stdId).findAny();

//        if(existingStd.isPresent()) {
//
//            existingStd.get().totalMarks = updatedStd.totalMarks;
//            return  existingStd.get();
//
//        }
//        else
//        {
//            return null;
//        }



    }
}

