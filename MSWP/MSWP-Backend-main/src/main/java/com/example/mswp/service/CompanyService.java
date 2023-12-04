package com.example.mswp.service;

import com.example.mswp.dto.CompanyDto;
import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.entity.Company;
import com.example.mswp.entity.Employee;
import com.example.mswp.repository.JpaCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CompanyService {

    private final JpaCompanyRepository jpaCompanyRepository;

    public Optional<Company> read(CompanyDto companyDto) {

        //SQL Read
        Optional<Company> test = jpaCompanyRepository.findById(companyDto.getCompId());

        if(test.isPresent()) {
            return test;
        } else {
            return null;
        }
    }

    public Map<String, Integer> create(CompanyDto companyDto) {

        Map<String, Integer> result = new HashMap<>();
        //SQL Read
        Optional<Company> test = jpaCompanyRepository.findById(companyDto.getCompId());

        if(test.isPresent()) {
            result.put("sc", 400);
        } else {
            Company company = companyDto.toEntity();
            jpaCompanyRepository.save(company);
            result.put("sc", 200);
        }

        return result;
    }

    public Map<String, Integer> delete(CompanyDto companyDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Company> test= jpaCompanyRepository.findById(companyDto.getCompId());

        if(test.isPresent()) {
            jpaCompanyRepository.deleteById(companyDto.getCompId());
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }
        return result;
    }

    public Map<String, Integer> update(CompanyDto companyDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Company> test = jpaCompanyRepository.findById(companyDto.getCompId());

        if (test.isPresent()) {
            Company companyToUpdate = test.get();

            if (companyDto.getCompPw() != null) {
                companyToUpdate.setCompPw(companyDto.getCompPw());
            }
            if (companyDto.getCompName() != null) {
                companyToUpdate.setCompName(companyDto.getCompName());
            }
            if (companyDto.getCompCeo() != null) {
                companyToUpdate.setCompCeo(companyDto.getCompCeo());
            }
            if (companyDto.getCompManager() != null) {
                companyToUpdate.setCompManager(companyDto.getCompManager());
            }
            if (companyDto.getCompEmail() != null) {
                companyToUpdate.setCompEmail(companyDto.getCompEmail());
            }
            if (companyDto.getCompAddress() != null) {
                companyToUpdate.setCompAddress(companyDto.getCompAddress());
            }

            jpaCompanyRepository.save(companyToUpdate);
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 회사가 없는 경우
        }

        return result;
    }
}
