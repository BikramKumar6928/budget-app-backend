package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Accessors(fluent = true)
@Entity
@NoArgsConstructor
@Table(name = "Income")
public class IncomeDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private long amount;

    @Column
    private String description;

    @JoinColumn(nullable = false)
    @ManyToOne
    private GroupDB group;

    public long budget(){
        return group().budget();
    }
}
