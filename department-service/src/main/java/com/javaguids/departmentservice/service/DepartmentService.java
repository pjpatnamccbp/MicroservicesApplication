package com.javaguids.departmentservice.service;

import com.javaguids.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    DepartmentDto getDepartmentByCode(String departmentCode);
}
