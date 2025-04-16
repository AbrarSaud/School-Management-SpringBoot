package com.example.jparelationi.Controller;


import com.example.jparelationi.API.ApiResponse;
import com.example.jparelationi.DTO.AddressDTO;

import com.example.jparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school_system/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    //     Get  teachers Address
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherAddressById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getTeacherAddress(id));
    }

    //     Add new teacher Address
    @PostMapping("/add")
    public ResponseEntity<?> addTeacherAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addTeacherAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("Added Teacher Address!!"));
    }

    //     Update teacher Address
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacherAddress(@PathVariable Integer id,@Valid @RequestBody AddressDTO addressDTO) {
        addressService.updateTeacherAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("Update Teacher Address!!"));
    }

    //     Delete teacher Address
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacherAddress(@PathVariable Integer id) {
        addressService.deleteTeacherAddress(id);
        return ResponseEntity.ok(new ApiResponse("Deleted Teacher Address!!"));
    }

}
