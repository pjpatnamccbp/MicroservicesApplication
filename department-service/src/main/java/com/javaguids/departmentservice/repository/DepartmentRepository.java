package com.javaguids.departmentservice.repository;

import com.javaguids.departmentservice.dto.DepartmentDto;
import com.javaguids.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String departmentCode);
}
