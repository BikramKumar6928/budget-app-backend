package com.example.demo.mapper.impl;

import com.example.demo.enums.IncomeType;
import com.example.demo.mapper.MapperInterface;
import com.example.demo.model.Income;
import com.example.demo.model.IncomeDB;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncomeToIncomeDBMapper implements MapperInterface<Income, IncomeDB> {

    @Override
    public IncomeDB map(Income income) {
        return new IncomeDB()
                .amount(income.getAmount())
                .id(income.getId())
                .description(income.getDescription())
                .incomeType(IncomeType.valueOf(income.getType()));
    }

    @Override
    public Income reverseMap(IncomeDB incomeDB) {
        return new Income()
                .amount(incomeDB.amount())
                .id(incomeDB.id())
                .description(incomeDB.description())
                .type(incomeDB.incomeType().name());
    }
}
