package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.CourseInstance;
import com.example.demo.repository.CourseInstanceRepository;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<?> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        if (courseInstance.getCourse() == null || courseInstance.getCourse().getId() == null) {
            return ResponseEntity.badRequest().body("Course must be provided");
        }

        Course course = courseRepository.findById(courseInstance.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        courseInstance.setCourse(course);

        CourseInstance savedCourseInstance = courseInstanceRepository.save(courseInstance);
        return ResponseEntity.ok(savedCourseInstance);
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<?> getCourseInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        List<CourseInstance> courseInstances = courseInstanceRepository.findByYearAndSemester(year, semester);
        return ResponseEntity.ok(courseInstances);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<?> getCourseInstanceByIdAndYearAndSemester(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        Optional<CourseInstance> courseInstance = courseInstanceRepository.findByIdAndYearAndSemester(id, year, semester);
        return courseInstance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<?> deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        Optional<CourseInstance> courseInstance = courseInstanceRepository.findByIdAndYearAndSemester(id, year, semester);
        if (courseInstance.isPresent()) {
            courseInstanceRepository.delete(courseInstance.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
