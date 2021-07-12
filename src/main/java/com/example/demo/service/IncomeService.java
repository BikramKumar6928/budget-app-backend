package com.example.demo.service;

import com.example.demo.model.Income;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class IncomeService {

    public Income enrichIncome(Income income) {
        UUID id = income.getId();
        if(Objects.isNull(id) || StringUtils.isEmpty(id.toString()))
            income.setId(UUID.randomUUID());
        return income;
    }
}
