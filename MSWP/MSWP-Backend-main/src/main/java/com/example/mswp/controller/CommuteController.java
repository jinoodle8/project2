package com.example.mswp.controller;

import com.example.mswp.dto.CommuteDto;
import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.entity.Commute;
import com.example.mswp.entity.Employee;
import com.example.mswp.service.CommuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/commute")

public class CommuteController {

    @Autowired
    private CommuteService commuteService;

    @PostMapping("/read")
    public Optional<Commute> read(@RequestBody CommuteDto commuteDto) { return commuteService.read(commuteDto); }

    @PostMapping("/create")
    public Map<String, Integer> create(@RequestBody CommuteDto commuteDto) { return commuteService.create(commuteDto); }

    @PostMapping("/delete")
    public Map<String, Integer> delete(@RequestBody CommuteDto commuteDto) { return commuteService.delete(commuteDto); }
}
