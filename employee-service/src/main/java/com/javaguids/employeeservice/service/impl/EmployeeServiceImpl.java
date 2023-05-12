package com.javaguids.employeeservice.service.impl;

import com.javaguids.employeeservice.dto.APIResponseDto;
import com.javaguids.employeeservice.dto.DepartmentDto;
import com.javaguids.employeeservice.dto.EmployeeDto;
import com.javaguids.employeeservice.entity.Employee;
import com.javaguids.employeeservice.repository.EmployeeRepository;
import com.javaguids.employeeservice.service.APIClient;
import com.javaguids.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;

    //private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getFirstName(),
                employeeDto.getFirstName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto =  new EmployeeDto(
                savedEmployee.getEmployeeId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "localhost:8080/api/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
//
//        DepartmentDto departmentDto = webClient.get()
//                .uri("localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        EmployeeDto employeeDto =  new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto =  new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
