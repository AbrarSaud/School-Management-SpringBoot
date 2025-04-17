package com.example.jparelationi.Repository;

import com.example.jparelationi.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);


    @Query("select c.teacher.id from Course c WHERE c.id = :id")
    Integer getCourseById(Integer id);

    Course getCofurseById(Integer id);
}
