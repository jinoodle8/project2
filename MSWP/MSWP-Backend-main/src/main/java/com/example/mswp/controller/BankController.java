package com.example.mswp.controller;

import com.example.mswp.dto.BankDto;
import com.example.mswp.entity.Bank;
import com.example.mswp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bank")

public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/read")
    public Optional<Bank> read(@RequestBody BankDto bankDto) {
        return bankService.read(bankDto);
    }

    @PostMapping("/create")
    public Map<String, Integer> create(@RequestBody BankDto bankDto) {
        return bankService.create(bankDto);
    }

    @PostMapping("/delete")
    public Map<String, Integer> delete(@RequestBody BankDto bankDto) { return bankService.delete(bankDto); }

    @PostMapping("/update")
    public  Map<String, Integer> update(@RequestBody BankDto bankDto) { return bankService.update(bankDto); }
}
