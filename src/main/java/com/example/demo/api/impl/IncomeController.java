package com.example.demo.api.impl;

import com.example.demo.api.IncomeApi;
import com.example.demo.model.Income;
import com.example.demo.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class IncomeController implements IncomeApi {

    @Autowired
    private IncomeService incomeService;

    @Override
    public ResponseEntity<Income> addIncome(Income income) {
        return ResponseEntity.ok(incomeService.addIncome(income));
    }

    @Override
    public ResponseEntity<Void> deleteIncomeById(UUID incomeId) {
        incomeService.deleteIncome(incomeId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Income>> getAllIncome() {
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @Override
    public ResponseEntity<Income> getIncomeById(UUID incomeId) {
        return ResponseEntity.ok(incomeService.getIncome(incomeId));
    }

    @Override
    public ResponseEntity<Income> updateIncome(Income income) {
        return ResponseEntity.ok(incomeService.updateIncome(income));
    }
}
