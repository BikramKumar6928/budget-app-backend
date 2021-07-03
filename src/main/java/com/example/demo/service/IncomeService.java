package com.example.demo.service;

import com.example.demo.mapper.impl.IncomeToIncomeDBMapper;
import com.example.demo.model.Income;
import com.example.demo.model.IncomeDB;
import com.example.demo.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeToIncomeDBMapper incomeToIncomeDBMapper;

    @Transactional
    public Income addIncome(Income income) {
        IncomeDB incomeDB = incomeToIncomeDBMapper.map(income);
        IncomeDB savedIncome = incomeRepository.save(incomeDB);
        return incomeToIncomeDBMapper.reverseMap(savedIncome);
    }

    @Transactional
    public void deleteIncome(UUID incomeId) {
        incomeRepository.deleteById(incomeId);
    }

    public List<Income> getAllIncome() {
        List<IncomeDB> incomeDBList = incomeRepository.findAll();
        return incomeDBList.stream()
                .map(incomeDB -> incomeToIncomeDBMapper.reverseMap(incomeDB))
                .collect(Collectors.toList());
    }

    public Income getIncome(UUID incomeId) {
        IncomeDB incomeDB = incomeRepository.getById(incomeId);
        return incomeToIncomeDBMapper.reverseMap(incomeDB);
    }

    public Income updateIncome(Income income) {
        return addIncome(income);
    }
}
