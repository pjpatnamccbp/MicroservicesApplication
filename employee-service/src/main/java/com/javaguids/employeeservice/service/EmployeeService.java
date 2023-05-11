package com.javaguids.employeeservice.service;

import com.javaguids.employeeservice.dto.APIResponseDto;
import com.javaguids.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
