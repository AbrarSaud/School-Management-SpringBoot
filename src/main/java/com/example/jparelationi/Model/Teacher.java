package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotEmpty(message = "The Name must be NOT Empty ")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @NotNull(message = "The Age must be NOT Null")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer age;

    @NotEmpty(message = "The Email must be NOT Empty ")
    @Email
    @Column(columnDefinition = "varchar(100) not null unique")
    private String email;

    @NotNull(message = "The Salary must be NOT Null")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
