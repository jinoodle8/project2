package com.example.mswp.service;

import com.example.mswp.dto.BankDto;
import com.example.mswp.entity.Bank;
import com.example.mswp.repository.JpaBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BankService {

    private final JpaBankRepository jpaBankRepository;

    public Optional<Bank> read(BankDto bankDto) {

        //SQL Read
        Optional<Bank> test = jpaBankRepository.findById(bankDto.getEmpId());

        if(test.isPresent()) {
            return test;
        } else {
            return null;
        }
    }

    public Map<String, Integer> create(BankDto bankDto) {

        Map<String, Integer> result = new HashMap<>();
        //SQL Read
        Optional<Bank> test = jpaBankRepository.findById(bankDto.getEmpId());

        if(test.isPresent()) {
            result.put("sc", 400);
        } else {
            Bank bank = bankDto.toEntity();
            jpaBankRepository.save(bank);
            result.put("sc", 200);
        }

        return result;
    }

    public Map<String, Integer> delete(BankDto bankDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Bank> test = jpaBankRepository.findById(bankDto.getEmpId());

        if(test.isPresent()) {
            jpaBankRepository.deleteById(bankDto.getEmpId());
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }
        return result;
    }

    public Map<String, Integer> update(BankDto bankDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Bank> test = jpaBankRepository.findById(bankDto.getEmpId());

        if (test.isPresent()) {
            Bank bankToUpdate = test.get();

            if (bankDto.getBankNum() != null) {
                bankToUpdate.setBankNum(bankDto.getBankNum());
            }
            if (bankDto.getBankName() != null) {
                bankToUpdate.setBankName(bankDto.getBankName());
            }
            if (bankDto.getBankOwner() != null) {
                bankToUpdate.setBankOwner(bankDto.getBankOwner());
            }
            if (bankDto.getEmpSalary() != null) {
                bankToUpdate.setEmpSalary(bankDto.getEmpSalary());
            }
            if (bankDto.getPayIncentive() != null) {
                bankToUpdate.setPayIncentive(bankDto.getPayIncentive());
            }

            jpaBankRepository.save(bankToUpdate);
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }

        return result;
    }
}