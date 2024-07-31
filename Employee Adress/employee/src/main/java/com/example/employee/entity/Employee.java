package com.example.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee Id")
    private Long id;

    @Column(name = "Employee Name")
    private String name;

    @Column(name = "Employee Email")
    private String email;

    @Column(name = "Employee Age")
    private int age;
}
