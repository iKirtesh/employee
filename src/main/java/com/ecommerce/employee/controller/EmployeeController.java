package com.ecommerce.employee.controller;

import com.ecommerce.employee.dto.EmployeeRequestDTO;
import com.ecommerce.employee.dto.EmployeeResponseDTO;
import com.ecommerce.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public EmployeeResponseDTO create(@Valid @RequestBody EmployeeRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/salary/{salary}")
    public List<EmployeeResponseDTO> getEmployeesBySalary(
            @PathVariable double salary
    ) {
        return service.getEmployeesBySalary(salary);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }
}
