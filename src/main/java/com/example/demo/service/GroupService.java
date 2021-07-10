package com.example.demo.service;

import com.example.demo.mapper.impl.GroupToGroupDBMapper;
import com.example.demo.model.Group;
import com.example.demo.model.GroupDB;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    
    @Autowired
    private GroupToGroupDBMapper groupToGroupDBMapper;

    public Group addGroup(Group group) {
        GroupDB groupDB = groupToGroupDBMapper.map(group);
        GroupDB savedGroupDB = groupRepository.save(groupDB);
        return groupToGroupDBMapper.reverseMap(savedGroupDB);
    }

    public void deleteGroup(UUID groupId) {
        groupRepository.deleteById(groupId);
    }

    public List<Group> getAllGroup() {
        List<GroupDB> groupDBList = groupRepository.findAll();
        return groupDBList.stream()
                .map(groupDB -> groupToGroupDBMapper.reverseMap(groupDB))
                .collect(Collectors.toList());
    }

    public Group getGroupById(UUID groupId) {
        GroupDB groupDB = groupRepository.getById(groupId);
        return groupToGroupDBMapper.reverseMap(groupDB);
    }

    public Group updateGroup(Group group) {
        return addGroup(group);
    }
}
