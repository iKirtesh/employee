package com.ecommerce.employee.dto;

import com.ecommerce.employee.model.EmployeeRole;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 18, message = "Age must be >= 18")
    private int age;

    @PastOrPresent(message = "Join date must be today or past")
    @NotNull(message = "Join date is required")
    private LocalDate joinDate;

    @FutureOrPresent(message = "Project join date must be today or future")
    @NotNull(message = "Project join date is required")
    private LocalDate projectJoinDate;

    @Positive(message = "Salary must be positive")
    private double salary;

    @NotNull(message = "Role is required")
    private EmployeeRole role;
}
