package com.example.demo.api.impl;

import com.example.demo.api.UserApi;
import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController implements UserApi {

    @Override
    public ResponseEntity<Void> createUser(User body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return null;
    }

    @Override
    public ResponseEntity<String> loginUser(String username, String password) {
        return ResponseEntity.ok("token");
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, User body) {
        return null;
    }
}
