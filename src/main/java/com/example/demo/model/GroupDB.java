package com.example.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Data
@Accessors(fluent = true)
@Entity
@Table
public class GroupDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private long budget;

    @OneToMany(mappedBy = "group")
    @Column
    private Set<IncomeDB> incomeDBSet;

}
