package com.example.jparelationi.Controller;


import com.example.jparelationi.API.ApiResponse;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school_system/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    //     Get all teachers
    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    //     Add new teacher
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok(new ApiResponse("Added Teacher!!"));
    }

    //     Update teacher
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok(new ApiResponse("Update Teacher!!"));
    }

    //     Delete teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(new ApiResponse("Deleted Teacher!!"));
    }

    // Get teacher details by id
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {
        Teacher teacher = teacherService.getTeacherDetails(id);
        return ResponseEntity.ok(teacher);
    }

}
