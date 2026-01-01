package com.ecommerce.employee.service;

import com.ecommerce.employee.exception.ResourceException;
import com.ecommerce.employee.repository.EmployeeRepository;
import com.ecommerce.employee.dto.EmployeeRequestDTO;
import com.ecommerce.employee.dto.EmployeeResponseDTO;
import com.ecommerce.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO dto) {

        if (repository.existsByName(dto.getName())) {
            throw new ResourceException("Employee already exists with name: " + dto.getName());
        }

        Employee employee = Employee.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .joinDate(dto.getJoinDate())
                .projectJoinDate(dto.getProjectJoinDate())
                .salary(dto.getSalary())
                .role(dto.getRole())
                .build();

        return mapToDTO(repository.save(employee));
    }


    @Override
    public EmployeeResponseDTO getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesBySalary(double salary) {
        return repository.findBySalary(salary)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    @Override
    public List<EmployeeResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(dto.getName());
        emp.setAge(dto.getAge());
        emp.setJoinDate(dto.getJoinDate());
        emp.setProjectJoinDate(dto.getProjectJoinDate());
        emp.setSalary(dto.getSalary());
        emp.setRole(dto.getRole());

        return mapToDTO(repository.save(emp));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private EmployeeResponseDTO mapToDTO(Employee e) {
        return EmployeeResponseDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .age(e.getAge())
                .joinDate(e.getJoinDate())
                .projectJoinDate(e.getProjectJoinDate())
                .salary(e.getSalary())
                .role(e.getRole())
                .build();
    }
}
