package com.example.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private int id;
    private String name;
    private String email;
    private String age;

    // Add AddressResponse Here
    private AddressDTO addressDTO;
}