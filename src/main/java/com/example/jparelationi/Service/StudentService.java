package com.example.jparelationi.Service;


import com.example.jparelationi.API.ApiException;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Get all Student
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // Add new Student
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    //  Update Student
    public void updateStudent(Integer id, Student student) {
        Student oldStudent = studentRepository.findStudentById(id);
        if (oldStudent == null) {
            throw new ApiException("Student NOT fund!!");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(student);
    }

    // Delete Student
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student NOT fund!!");
        }
        studentRepository.delete(student);
    }

    public void assignCourseToStudent(Integer course_id, Integer student_id) {
        Course course = courseRepository.findCourseById(course_id);
        Student student = studentRepository.findStudentById(student_id);

        if (course == null || student == null) {
            throw new ApiException("Can't assign course to student ");
        }

        course.getStudents().add(student);
        student.getCourses().add(course);

        courseRepository.save(course);
        studentRepository.save(student);
    }

    // Create endpoint that takes course id and return the student list
    public List<String> getStudentNamesInCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("course Not Found!!");
        }
        List<String> names = new ArrayList<>();

        for (Student student : course.getStudents()) {
            names.add(student.getName());
        }
        return names;
    }

    // Create endpoint that takes student id and major and change the student major
    public void changeStudentMajor(Integer studentId, String newMajor) {
        Student student = studentRepository.findStudentById(studentId);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        student.setMajor(newMajor);

        studentRepository.save(student);
    }

}
