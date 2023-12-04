package com.example.mswp.service;

import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.dto.VacationDto;
import com.example.mswp.entity.Employee;
import com.example.mswp.entity.Vacation;
import com.example.mswp.repository.JpaVacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class VacationService {

    private final JpaVacationRepository jpaVacationRepository;

    public Optional<Vacation> read(VacationDto vacationDto) {

        //SQL Read
        Optional<Vacation> test = jpaVacationRepository.findById(vacationDto.getEmpId());

        if(test.isPresent()) {
            return test;
        } else {
            return null;
        }
    }

    public Map<String, Integer> create(VacationDto vacationDto) {

        Map<String, Integer> result = new HashMap<>();
        //SQL Read
        Optional<Vacation> test = jpaVacationRepository.findById(vacationDto.getEmpId());

        if(test.isPresent()) {
            result.put("sc", 400);
        } else {
            Vacation vacation = vacationDto.toEntity();
            jpaVacationRepository.save(vacation);
            result.put("sc", 200);
        }

        return result;
    }

    public Map<String, Integer> delete(VacationDto vacationDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Vacation> test= jpaVacationRepository.findById(vacationDto.getEmpId());

        if(test.isPresent()) {
            jpaVacationRepository.deleteById(vacationDto.getEmpId());
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }
        return result;
    }

    public Map<String, Integer> update(VacationDto vacationDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Vacation> test = jpaVacationRepository.findById(vacationDto.getEmpId());

        if (test.isPresent()) {
            Vacation vacationToUpdate = test.get();

            if (vacationDto.getVacName() != null) {
                vacationToUpdate.setVacName(vacationDto.getVacName());
            }
            if (vacationDto.getVacRemind() != null) {
                vacationToUpdate.setVacRemind(vacationDto.getVacRemind());
            }

            jpaVacationRepository.save(vacationToUpdate);
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }

        return result;
    }

}
