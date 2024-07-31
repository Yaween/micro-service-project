package com.example.service;

import com.example.dto.AddressDTO;
import com.example.dto.EmployeeDTO;
import com.example.entity.Employee;
import com.example.feignclient.AddressClient;
import com.example.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ModelMapper mapper;

    // Spring will create the implementation
    // for this class
    // and will inject the bean here (proxy)
    @Autowired
    private AddressClient addressClient;

    public EmployeeDTO getEmployeeById(int id) {

        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeDTO employeeResponse = mapper.map(employee, EmployeeDTO.class);

        // Using FeignClient
        ResponseEntity<AddressDTO> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressDTO(addressResponse.getBody());

        return employeeResponse;
    }
}
