package com.example.mswp.service;

import com.example.mswp.dto.DepartmentDto;
import com.example.mswp.entity.Department;
import com.example.mswp.repository.JpaDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class DepartmentService {

    private final JpaDepartmentRepository jpaDepartmentRepository;

    public Optional<Department> read(DepartmentDto departmentDto) {

        //SQL Read
        Optional<Department> test = jpaDepartmentRepository.findById(departmentDto.getDepCode());

        if(test.isPresent()) {
            return test;
        } else {
            return null;
        }
    }

    public Map<String, Integer> create(DepartmentDto departmentDto) {

        Map<String, Integer> result = new HashMap<>();
        //SQL Read
        Optional<Department> test = jpaDepartmentRepository.findById(departmentDto.getDepCode());

        if(test.isPresent()) {
            result.put("sc", 400);
        } else {
            Department department = departmentDto.toEntity();
            jpaDepartmentRepository.save(department);
            result.put("sc", 200);
        }

        return result;
    }



    public Map<String, Integer> delete(DepartmentDto departmentDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Department> test= jpaDepartmentRepository.findById(departmentDto.getDepCode());

        if(test.isPresent()) {
            jpaDepartmentRepository.deleteById(departmentDto.getDepCode());
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }
        return result;
    }
}
