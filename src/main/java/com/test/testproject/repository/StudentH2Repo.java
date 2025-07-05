package com.test.testproject.repository;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface StudentH2Repo extends JpaRepository<Student, Integer> {

    public Optional<Student> findByStdName(String searchName);

    @Query("SELECT s FROM Student s WHERE s.stdName like %?1% ")
    Optional<Student> findByStdNameContaining(String searchName);
}
