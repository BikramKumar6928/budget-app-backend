package com.example.demo.api.impl;

import com.example.demo.api.IncomeApi;
import com.example.demo.model.Income;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeController implements IncomeApi {
    @Override
    public ResponseEntity<Income> addIncome(Income body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteIncomeById(Long incomeId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Income>> getAllIncome() {
        return null;
    }

    @Override
    public ResponseEntity<Income> getIncomeById(Long incomeId) {
        Income income = new Income();
        income.setId(incomeId);
        return ResponseEntity.ok(income);
    }

    @Override
    public ResponseEntity<Income> updateIncome(Income body) {
        return null;
    }
}
