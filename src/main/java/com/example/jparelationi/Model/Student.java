package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotEmpty
    private String name;

    @NotNull(message = "The Age must be NOT Null")
    @Positive
    private Integer age;

    @NotEmpty
    private String major;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private Set<Course> courses;
}

