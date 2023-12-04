package com.example.mswp.service;

import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.entity.Employee;
import com.example.mswp.repository.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    public Optional<Employee> read(EmployeeDto employeeDto) {

        //SQL Read
        Optional<Employee> test = jpaEmployeeRepository.findById(employeeDto.getEmpId());
        System.out.println(test.get());
        if(test.isPresent()) {
            return test;
        } else {
            return null;
        }
    }

    public Map<String, Integer> create(EmployeeDto employeeDto) {

        Map<String, Integer> result = new HashMap<>();
        //SQL Read
        Optional<Employee> test = jpaEmployeeRepository.findById(employeeDto.getEmpId());

        if(test.isPresent()) {
            result.put("sc", 400);
        } else {
            Employee employee = employeeDto.toEntity();
            jpaEmployeeRepository.save(employee);
            result.put("sc", 200);
        }

        return result;
    }

    public Optional<Employee> login(EmployeeDto employeeDto){ //로그인
        Optional<Employee> test = jpaEmployeeRepository.findById(employeeDto.getEmpId());

        if(test.isPresent()) {
            Employee employee = test.get();
            String password = employee.getEmpPw(); // 비밀번호 조회

            if(employeeDto.getEmpPw().equals(password)) {
                return test;
            }else{
                return null;
            }
        } else {
            return null;
        }
    }

    public Map<String, Integer> delete(EmployeeDto employeeDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Employee> test= jpaEmployeeRepository.findById(employeeDto.getEmpId());

        if(test.isPresent()) {
            jpaEmployeeRepository.deleteById(employeeDto.getEmpId());
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }
        return result;
    }

    public Map<String, Integer> update(EmployeeDto employeeDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Employee> test = jpaEmployeeRepository.findById(employeeDto.getEmpId());

        if (test.isPresent()) {
            Employee employeeToUpdate = test.get();

            if (employeeDto.getEmpName() != null) {
                employeeToUpdate.setEmpName(employeeDto.getEmpName());
            }
            if (employeeDto.getBankNum() != null) {
                employeeToUpdate.setBankNum(employeeDto.getBankNum());
            }
            if (employeeDto.getEmpSalary() != null) {
                employeeToUpdate.setEmpSalary(employeeDto.getEmpSalary());
            }
            if (employeeDto.getEmpPhone() != null) {
                employeeToUpdate.setEmpPhone(employeeDto.getEmpPhone());
            }
            if (employeeDto.getEmpPw() != null) {
                employeeToUpdate.setEmpPw(employeeDto.getEmpPw());
            }
            if (employeeDto.getEmpRank() != null) {
                employeeToUpdate.setEmpRank(employeeDto.getEmpRank());
            }
            if (employeeDto.getEmpAddress() != null) {
                employeeToUpdate.setEmpAddress(employeeDto.getEmpAddress());
            }

            jpaEmployeeRepository.save(employeeToUpdate);
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }

        return result;
    }
}
