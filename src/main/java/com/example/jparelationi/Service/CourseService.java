package com.example.jparelationi.Service;


import com.example.jparelationi.API.ApiException;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    //    Get all courses
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    //    Add new course
    public void addCoursesWithTeacher(Course course, Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new ApiException("Teacher Not Found!!");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    private void assignCourse(Integer courseId, Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        if (teacher == null) {
            throw new ApiException("Teacher Not Found!!");
        }
        if (course == null) {
            throw new ApiException("Course Not Found!!");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    //    Update course
    public void updateCourse(Course course) {
        Course oldCourse = courseRepository.findCourseById(course.getId());
        if (oldCourse == null) {
            throw new ApiException("Course Not Found!!");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    //    Delete Course
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course Not Found!!");
        }
        courseRepository.delete(course);

    }

    // Create endpoint that take course id and return the teacher name for that class
    public String getTeacherNamesInCourse(Integer id) {
        Integer courseById = courseRepository.getCourseById(id);
        if (courseById == null) {
            throw new ApiException("course Not Found!!");
        }
        return teacherRepository.getTeacherNameById(courseById);
    }
}
