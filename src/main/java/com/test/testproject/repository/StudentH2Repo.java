package com.test.testproject.repository;

import com.test.testproject.dto.StudentDto;
import com.test.testproject.models.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface StudentH2Repo extends JpaRepository<Student, Integer> {

    public Optional<Student> findByStdName(String searchName);

    @Query("SELECT s FROM Student s WHERE s.stdName like %?1% ")
    Optional<Student> findByStdNameContaining(String searchName);

    Optional<List<Student>> findByTotalMarksGreaterThan(int expectedMarks);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.stdId = :id and s.stdName = :name")
    int deleteByIdAndName(@Param("id") int id ,@Param("name") String name );
}
