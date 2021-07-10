package com.example.demo.api.impl;

import com.example.demo.api.GroupApi;
import com.example.demo.model.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GroupController implements GroupApi {
    @Autowired
    private GroupService groupService;

    @Override
    public ResponseEntity<Group> addGroup(Group group) {
        return ResponseEntity.ok(groupService.addGroup(group));
    }

    @Override
    public ResponseEntity<Void> deleteGroupById(UUID groupId) {
        groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Group>> getAllGroup() {
        return ResponseEntity.ok(groupService.getAllGroup());
    }

    @Override
    public ResponseEntity<Group> getGroupById(UUID groupId) {
        return ResponseEntity.ok(groupService.getGroupById(groupId));
    }

    @Override
    public ResponseEntity<Group> updateGroup(Group group) {
        return ResponseEntity.ok(groupService.updateGroup(group));
    }
}
