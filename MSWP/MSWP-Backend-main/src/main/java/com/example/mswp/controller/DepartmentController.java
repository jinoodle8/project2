package com.example.mswp.controller;

import com.example.mswp.dto.DepartmentDto;
import com.example.mswp.entity.Department;
import com.example.mswp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/read")
    public Optional<Department> read(@RequestBody DepartmentDto departmentDto) {
        return departmentService.read(departmentDto);
    }

    @PostMapping("/create")
    public Map<String, Integer> create(@RequestBody DepartmentDto departmentDto) {
        return departmentService.create(departmentDto);
    }

    @PostMapping("/delete")
    public Map<String, Integer> delete(@RequestBody DepartmentDto departmentDto) {
        return departmentService.delete(departmentDto);
    }
}
