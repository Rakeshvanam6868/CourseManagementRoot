package com.example.demo.repository;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface CourseRepository extends JpaRepository<Course, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Course c WHERE c.id = :id")
    void deleteById(Long id);
}
