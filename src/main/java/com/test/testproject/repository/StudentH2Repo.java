package com.test.testproject.repository;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentH2Repo extends JpaRepository<Student, Integer> {
}
