package com.example.mswp.controller;

import com.example.mswp.dto.CompanyDto;
import com.example.mswp.dto.VacationDto;
import com.example.mswp.entity.Vacation;
import com.example.mswp.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacation")

public class VacationController {

    @Autowired
    private VacationService vacationService;

    @PostMapping("/read")
    public Optional<Vacation> read(@RequestBody VacationDto vacationDto) {
        return vacationService.read(vacationDto);
    }

    @PostMapping("/create")
    public Map<String, Integer> create(@RequestBody VacationDto vacationDto) {
        return vacationService.create(vacationDto);
    }

    @PostMapping("/delete")
    public Map<String, Integer> delete(@RequestBody VacationDto vacationDto) {
        return vacationService.delete(vacationDto);
    }

    @PostMapping("/update")
    public  Map<String, Integer> update(@RequestBody VacationDto vacationDto) { return vacationService.update(vacationDto); }

}
