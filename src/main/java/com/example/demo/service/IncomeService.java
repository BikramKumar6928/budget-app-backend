package com.example.demo.service;

import com.example.demo.model.Income;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IncomeService {

    public Income enrichIncome(Income income) {
        income.setId(UUID.randomUUID());
        return income;
    }
}
