package com.test.testproject.repository;

import com.test.testproject.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentH2Repo extends JpaRepository<StudentDto, Integer> {
}
