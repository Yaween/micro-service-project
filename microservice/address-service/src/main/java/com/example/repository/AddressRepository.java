package com.example.repository;

import com.example.entity.Address;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
    @Query(nativeQuery = true, value = "SELECT ea.id, ea.city, ea.state FROM gfgmicroservicesdemo.address ea join gfgmicroservicesdemo.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
