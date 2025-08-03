package com.test.testproject.mapper;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    @Mapping(source = "stdId", target = "studentId")
    @Mapping(source = "stdRoll", target = "studentRoll")
    @Mapping(source = "stdName", target = "studentName")
    @Mapping(source = "stdClass", target = "studentClass")
    //@Mapping(source = "address.city", target = "cityName") // (3) Flatten nested field
    @Mapping(target = "isStudentPass", ignore = true)
    // Convert Entity/Model to DTO single object
    StudentDto toDTO(Student user);
    // Convert List Entity/Model to DTO List object
    List<StudentDto> toDTOList(List<Student> users);

    @Mapping(source = "studentId", target = "stdId")
    @Mapping(source = "studentRoll", target = "stdRoll")
    @Mapping(source = "studentName", target = "stdName")
    @Mapping(source = "studentClass", target = "stdClass")
    // Convert DTO to Entity/Model single object
    Student toEntity(StudentDto userDTO);
    // Convert DTO List to Entity/Model List object
    List<Student> toEntityList(List<StudentDto> dtoList);

    @AfterMapping
    default void setPassStatus(Student student, @MappingTarget StudentDto dto) {
        dto.setIsStudentPass(student.getTotalMarks() > 80 ? "pass" : "fail");
    }
}
