package com.example.address.repository;

import com.example.address.entity.Address;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long>{
    @Query(nativeQuery = true, value = "SELECT ea.id, ea.city, ea.state FROM shopping_center.address ea join shopping_center.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") Long employeeId);
}
