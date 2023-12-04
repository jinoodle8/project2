package com.example.mswp.controller;


import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.entity.Employee;
import com.example.mswp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/read")
    public Optional<Employee> read(@RequestBody EmployeeDto employeeDto) {
        return employeeService.read(employeeDto);
    }

    @PostMapping("/create")
    public Map<String, Integer> create(@RequestBody EmployeeDto employeeDto) { return employeeService.create(employeeDto); }

    @PostMapping("/login")
    public Optional<Employee> login(@RequestBody EmployeeDto employeeDto) {
        return employeeService.login(employeeDto);
    }

    @PostMapping("/delete")
    public Map<String, Integer> delete(@RequestBody EmployeeDto employeeDto) { return employeeService.delete(employeeDto); }

    @PostMapping("/update")
    public  Map<String, Integer> update(@RequestBody EmployeeDto employeeDto) { return employeeService.update(employeeDto); }

//        if (result.get("sc") == 200) { 200, 400으로 나눈 이유는 백엔드에서 postman을 했을때 결과값만 보여주기위해서 한거라
//        굳이 텍스트로 나태낼 필요가 없음 밑에 텍스트 같은 경우는 프론트가 해줘야하는 로직임
//            return ResponseEntity.ok("User with ID: " + employeeDto.getEmpId() + " has been updated successfully.");
//        } else if (result.get("sc") == 400) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User found with ID: " + employeeDto.getEmpId());
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user with ID: " + employeeDto.getEmpId());
//        }
}
