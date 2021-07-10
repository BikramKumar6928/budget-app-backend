package com.example.demo.mapper.impl;

import com.example.demo.mapper.MapperInterface;
import com.example.demo.model.Group;
import com.example.demo.model.GroupDB;
import org.springframework.stereotype.Component;

@Component
public class GroupToGroupDBMapper implements MapperInterface<Group, GroupDB> {
    @Override
    public GroupDB map(Group group) {
        return new GroupDB()
                .name(group.getName())
                .description(group.getDescription())
                .budget(group.getBudget())
                .id(group.getId());
    }

    @Override
    public Group reverseMap(GroupDB groupDB) {
        return new Group()
                .name(groupDB.name())
                .description(groupDB.description())
                .budget(groupDB.budget())
                .id(groupDB.id());
    }
}
