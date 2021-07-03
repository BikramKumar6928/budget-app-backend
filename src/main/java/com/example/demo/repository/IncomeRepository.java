package com.example.demo.repository;

import com.example.demo.model.IncomeDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncomeRepository extends JpaRepository<IncomeDB, UUID> {
}
