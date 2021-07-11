package com.example.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_income_mapping",
            joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "income_id", referencedColumnName = "id")})
    @MapKey(name = "id")
    private Map<UUID, IncomeDB> incomeMap;

    public void clean() {
        budget(0L);
    }
}
