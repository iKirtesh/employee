package com.ecommerce.employee.dto;

import com.ecommerce.employee.model.EmployeeRole;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private int age;
    private LocalDate joinDate;
    private LocalDate projectJoinDate;
    private double salary;
    private EmployeeRole role;
}