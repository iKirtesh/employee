package com.ecommerce.employee.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    private LocalDate joinDate;
    private LocalDate projectJoinDate;

    private double salary;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
}
