package com.example.demo.mapper.impl;

import com.example.demo.mapper.MapperInterface;
import com.example.demo.model.Group;
import com.example.demo.model.GroupDB;
import com.example.demo.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupToGroupDBMapper implements MapperInterface<Group, GroupDB> {

    @Autowired
    private IncomeToIncomeDBMapper incomeToIncomeDBMapper;

    @Override
    public GroupDB map(Group group) {
        return new GroupDB()
                .name(group.getName())
                .description(group.getDescription())
                .budget(group.getBudget())
                .incomeMap(group
                        .getIncomeList()
                        .stream()
                        .collect(Collectors
                                .toMap(
                                        Income::getId,
                                        income -> incomeToIncomeDBMapper.map(income)
                                )
                        )
                )
                .id(group.getId());
    }

    @Override
    public Group reverseMap(GroupDB groupDB) {
        return new Group()
                .name(groupDB.name())
                .description(groupDB.description())
                .budget(groupDB.budget())
                .incomeList(incomeToIncomeDBMapper
                        .reverseMapList(
                                new ArrayList<>(groupDB
                                        .incomeMap()
                                        .values())))
                .id(groupDB.id());
    }
}
