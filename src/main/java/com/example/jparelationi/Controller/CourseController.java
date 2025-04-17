package com.example.jparelationi.Controller;

import com.example.jparelationi.API.ApiResponse;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school_system/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @PostMapping("/add/{teacherId}/course")
    public ResponseEntity<?> addCourses(@Valid @RequestBody Course course, @PathVariable Integer teacherId) {
        courseService.addCoursesWithTeacher(course, teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Course added !!"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCourse(@Valid @RequestBody Course course) {
        courseService.updateCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Update"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course delete"));

    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<?> getTeacherNamesInCourse(@PathVariable Integer id) {
        String teacherNames = courseService.getTeacherNamesInCourse(id);
        return ResponseEntity.ok(new ApiResponse(teacherNames));
    }
}
