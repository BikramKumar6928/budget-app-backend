package com.example.demo.service;

import com.example.demo.BudgetException;
import com.example.demo.mapper.impl.GroupToGroupDBMapper;
import com.example.demo.mapper.impl.IncomeToIncomeDBMapper;
import com.example.demo.model.Group;
import com.example.demo.model.GroupDB;
import com.example.demo.model.Income;
import com.example.demo.model.IncomeDB;
import com.example.demo.repository.GroupRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private IncomeService incomeService;
    
    @Autowired
    private GroupToGroupDBMapper groupToGroupDBMapper;

    @Autowired
    private IncomeToIncomeDBMapper incomeToIncomeDBMapper;

    public Group addGroup(Group group) {
        GroupDB groupDB = groupToGroupDBMapper.map(group);
        groupDB.clean();
        GroupDB savedGroupDB = groupRepository.save(groupDB);
        return groupToGroupDBMapper.reverseMap(savedGroupDB);
    }

    public void deleteGroup(UUID groupId) {
        groupRepository.deleteById(groupId);
    }

    public List<Group> getAllGroup() {
        List<GroupDB> groupDBList = groupRepository.findAll();
        return mapAllGroupDBToGroup(groupDBList);
    }

    private List<Group> mapAllGroupDBToGroup(List<GroupDB> groupDBList) {
        return groupDBList.stream()
                .map(groupDB -> groupToGroupDBMapper.reverseMap(groupDB))
                .collect(Collectors.toList());
    }

    public Group getGroupById(UUID groupId) {
        GroupDB groupDB = groupRepository.getById(groupId);
        return groupToGroupDBMapper.reverseMap(groupDB);
    }

    public Group updateGroup(Group group) {
        getGroupById(group.getId());
        return addGroup(group);
    }

    public Income addIncome(UUID groupId, Income income) {
        GroupDB groupDB = groupRepository.getById(groupId);
        Map<UUID, IncomeDB> currentIncome = groupDB.incomeMap();
        Income updatedIncome = incomeService.enrichIncome(income);
        UUID incomeId = updatedIncome.getId();
        IncomeDB incomeDB = incomeToIncomeDBMapper.map(income);
        currentIncome.put(incomeId, incomeDB);
        groupDB.incomeMap(currentIncome);
        GroupDB updatedGroupDB = groupRepository.save(groupDB);
        IncomeDB updatedIncomeDB = updatedGroupDB.incomeMap().get(incomeId);
        return incomeToIncomeDBMapper.reverseMap(updatedIncomeDB);
    }

    public void deleteIncome(UUID groupId, UUID incomeId) {
        GroupDB groupDB = groupRepository.getById(groupId);
        Map<UUID, IncomeDB> currentIncomeMap = groupDB.incomeMap();
        currentIncomeMap.remove(incomeId);
        groupDB.incomeMap(currentIncomeMap);
        groupRepository.save(groupDB);
    }

    public List<Income> getAllIncome(UUID groupId) {
        GroupDB groupDB = groupRepository.getById(groupId);
        ArrayList<IncomeDB> incomeDBList = new ArrayList<>(groupDB.incomeMap().values());
        return incomeToIncomeDBMapper.reverseMapList(incomeDBList);
    }

    public Income getIncomeById(UUID groupId, UUID incomeId) {
        GroupDB groupDB = groupRepository.getById(groupId);
        IncomeDB incomeDB = groupDB.incomeMap().get(incomeId);
        return incomeToIncomeDBMapper.reverseMap(incomeDB);
    }

    public Income updateIncome(UUID groupId, Income income) {
        GroupDB groupDB = groupRepository.getById(groupId);
        UUID incomeId = income.getId();
        Income updatedIncome = incomeService.enrichIncome(income);
        IncomeDB updatedIncomeDB = incomeToIncomeDBMapper.map(updatedIncome);
        groupDB.incomeMap().put(incomeId, updatedIncomeDB);
        GroupDB updatedGroupDB = groupRepository.save(groupDB);
        IncomeDB incomeDB = updatedGroupDB.incomeMap().get(incomeId);
        return incomeToIncomeDBMapper.reverseMap(incomeDB);
    }
}
