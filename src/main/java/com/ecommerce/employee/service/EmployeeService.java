package com.ecommerce.employee.service;


import com.ecommerce.employee.dto.EmployeeRequestDTO;
import com.ecommerce.employee.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO create(EmployeeRequestDTO dto);

    EmployeeResponseDTO getById(Long id);

    List<EmployeeResponseDTO> getEmployeesBySalary(double salary);

    List<EmployeeResponseDTO> getAll();

    EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto);

    void delete(Long id);
}