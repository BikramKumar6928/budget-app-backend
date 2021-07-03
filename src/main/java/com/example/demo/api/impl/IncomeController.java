package com.example.demo.api.impl;

import com.example.demo.api.IncomeApi;
import com.example.demo.model.Income;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class IncomeController implements IncomeApi {
    @Override
    public ResponseEntity<Income> addIncome(Income body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteIncomeById(UUID incomeId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Income>> getAllIncome() {
        return null;
    }

    @Override
    public ResponseEntity<Income> getIncomeById(UUID incomeId) {
        return null;
    }

    @Override
    public ResponseEntity<Income> updateIncome(Income body) {
        return null;
    }
}
