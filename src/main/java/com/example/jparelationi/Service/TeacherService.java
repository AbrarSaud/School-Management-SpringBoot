package com.example.jparelationi.Service;


import com.example.jparelationi.API.ApiException;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    // Get all teachers
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    // Add new teacher
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    //  Update teacher
    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher == null) {
            throw new ApiException("Teacher NOT fund!!");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        if (teacherRepository.existsByEmail(teacher.getEmail())) {
            throw new ApiException("Email is exists");
        }
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(teacher);
    }

    // Delete teacher
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher NOT fund!!");
        }
        teacherRepository.delete(teacher);
    }

    // Get teacher details by id
    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher NOT found!!");
        }
        return teacher;
    }
}
