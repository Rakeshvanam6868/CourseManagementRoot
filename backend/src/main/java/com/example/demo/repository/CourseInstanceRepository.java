package com.example.demo.repository;

import com.example.demo.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
    Optional<CourseInstance> findByIdAndYearAndSemester(Long id, int year, int semester);

    // New method to find by course ID
    List<CourseInstance> findByCourseId(Long courseId);
}
