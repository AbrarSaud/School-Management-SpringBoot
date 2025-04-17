package com.example.jparelationi.Repository;

import com.example.jparelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById(Integer id);

    boolean existsByEmail(String email);

    @Query("select t.name from Teacher t where t.id in :id")
    String getTeacherNameById(Integer id);


}
