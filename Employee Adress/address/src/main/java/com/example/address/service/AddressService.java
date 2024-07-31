package com.example.address.service;

import com.example.address.dto.AddressDTO;
import com.example.address.entity.Address;
import com.example.address.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressDTO findAddressByEmployeeId(Long employeeId) {
        Optional<Address> addressByEmployeeId = addressRepository.findAddressByEmployeeId(employeeId);
        AddressDTO addressDTO = modelMapper.map(addressByEmployeeId, AddressDTO.class);
        return addressDTO;
    }
}
