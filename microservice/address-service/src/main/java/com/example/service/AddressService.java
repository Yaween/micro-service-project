package com.example.service;

import com.example.dto.AddressDTO;
import com.example.entity.Address;
import com.example.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressDTO findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
        AddressDTO addressResponse = mapper.map(addressByEmployeeId, AddressDTO.class);
        return addressResponse;
    }

}
