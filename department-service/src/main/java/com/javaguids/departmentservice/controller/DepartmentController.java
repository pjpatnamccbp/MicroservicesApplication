package com.javaguids.departmentservice.controller;

import com.javaguids.departmentservice.dto.DepartmentDto;
import com.javaguids.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    //build savedDepartment rest API

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId),HttpStatus.OK);
    }

    @GetMapping("/code/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode),HttpStatus.OK);
    }
}
