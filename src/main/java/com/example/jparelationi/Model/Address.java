package com.example.jparelationi.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "Area must be NOT Empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @NotEmpty(message = "Street must be NOT Empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;


    @NotNull(message = "Building number must be NOT Null")
    @Positive(message = "Building number must be positive")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
