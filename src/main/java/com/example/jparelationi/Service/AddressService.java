package com.example.jparelationi.Service;

import com.example.jparelationi.API.ApiException;
import com.example.jparelationi.DTO.AddressDTO;
import com.example.jparelationi.Model.Address;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.AddressRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getTeacherAddress(Integer id) {
        return addressRepository.getAddressById(id);
    }

    //    Add teacher address
    public void addTeacherAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.teacher_id);
        if (teacher == null) {
            throw new ApiException("Teacher NOT found!!");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    //    Update teacher address
    public void updateTeacherAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.teacher_id);
        if (address == null) {
            throw new ApiException("Teacher NOT found!!");
        }

        address.setArea(address.getArea());
        address.setStreet(address.getStreet());
        address.setBuildingNumber(address.getBuildingNumber());

        addressRepository.save(address);
    }

    //    Delete teacher address
    public void deleteTeacherAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Teacher NOT found!!");
        }
        addressRepository.delete(address);
    }
}
