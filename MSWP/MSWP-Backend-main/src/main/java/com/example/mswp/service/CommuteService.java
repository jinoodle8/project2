package com.example.mswp.service;

import com.example.mswp.dto.CommuteDto;
import com.example.mswp.dto.EmployeeDto;
import com.example.mswp.entity.Commute;
import com.example.mswp.entity.Employee;
import com.example.mswp.repository.JpaCommuteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CommuteService {
    private final JpaCommuteRepository jpaCommuteRepository;

    public Optional<Commute> read(CommuteDto commuteDto) {

        //SQL Read
        Optional<Commute> test = jpaCommuteRepository.findById(commuteDto.getEmpId());

        if(test.isPresent()) {
            return test;
        } else {
            return null;
        }
    }

    public Map<String, Integer> create(CommuteDto commuteDto) {

        Map<String, Integer> result = new HashMap<>();
        //SQL Read
        Optional<Commute> test = jpaCommuteRepository.findById(commuteDto.getEmpId());

        if(test.isPresent()) {
            result.put("sc", 400);
        } else {
            Commute commute = commuteDto.toEntity();
            jpaCommuteRepository.save(commute);
            result.put("sc", 200);
        }

        return result;
    }

    public Map<String, Integer> delete(CommuteDto commuteDto) {
        Map<String, Integer> result = new HashMap<>();

        Optional<Commute> test= jpaCommuteRepository.findById(commuteDto.getEmpId());

        if(test.isPresent()) {
            jpaCommuteRepository.deleteById(commuteDto.getEmpId());
            result.put("sc", 200);
        } else {
            result.put("sc", 400); // 해당 직원이 없는 경우
        }
        return result;
    }
}
