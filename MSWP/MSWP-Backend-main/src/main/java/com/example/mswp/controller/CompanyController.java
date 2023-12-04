package com.example.mswp.controller;

import com.example.mswp.dto.CompanyDto;
import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.entity.Company;
import com.example.mswp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")

public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/read")
    public Optional<Company> read(@RequestBody CompanyDto companyDto) {
        return companyService.read(companyDto);
    }

    @PostMapping("/create")
    public Map<String, Integer> create(@RequestBody CompanyDto companyDto) {
        return companyService.create(companyDto);
    }

    @PostMapping("/delete")
    public Map<String, Integer> delete(@RequestBody CompanyDto companyDto) {
        return companyService.delete(companyDto);
    }

    @PostMapping("/update")
    public  Map<String, Integer> update(@RequestBody CompanyDto companyDto) { return companyService.update(companyDto); }


}
