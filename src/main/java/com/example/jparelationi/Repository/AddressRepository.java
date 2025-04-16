package com.example.jparelationi.Repository;

import com.example.jparelationi.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);

    @Query("select  a from Address  a where a.id =?1")
    List<Address> getAddressById(Integer id);
}
