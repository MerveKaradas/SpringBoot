package com.doyur.demo.service.abstracts;

import com.doyur.demo.dto.request.CreateUserRequest;
import com.doyur.demo.model.User;

import java.net.URI;
import java.util.List;

public interface UserService {
    User save(CreateUserRequest createUserRequest);

    List<User> getAllUsers();

    User findUserById(int id);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
