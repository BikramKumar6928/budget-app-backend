package com.example.demo.model;

import com.example.demo.enums.IncomeType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Accessors(fluent = true)
@Entity
@Table(name = "income")
public class IncomeDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private long amount;

    @Column
    private String description;

    @Column(name = "income_type")
    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;
}
