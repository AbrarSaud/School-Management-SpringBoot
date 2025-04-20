package com.example.jparelationi.Controller;


import com.example.jparelationi.API.ApiResponse;
import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school_system/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    //     Get all Student
    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    //     Add new Student
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok(new ApiResponse("Added Student!!"));
    }

    //     Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok(new ApiResponse("Update Student!!"));
    }

    //     Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(new ApiResponse("Deleted Student!!"));
    }

    // Assign  course to  student
    @PutMapping("/assign-course/{studentId}/{courseId}")
    public ResponseEntity<?> assignCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignCourseToStudent(courseId, studentId);
        return ResponseEntity.ok().body(new ApiResponse("Course assigned to student successfully !!"));
    }

    // Create endpoint that takes course id and return the student list
    @GetMapping("/student-names/{courseId}")
    public ResponseEntity<?> getStudentNames(@PathVariable Integer courseId) {
        List<String> names = studentService.getStudentNamesInCourse(courseId);
        return ResponseEntity.ok(names);
    }

    // Create endpoint that takes student id and major and change the student major
    @PutMapping("/change-major/{studentId}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer studentId, @RequestParam String newMajor
    ) {
        studentService.changeStudentMajor(studentId, newMajor);
        return ResponseEntity.ok(new ApiResponse("Student major updated and all courses dropped."));
    }


}
