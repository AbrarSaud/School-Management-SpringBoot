package com.example.jparelationi.DTO;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    public Integer teacher_id;


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

}
