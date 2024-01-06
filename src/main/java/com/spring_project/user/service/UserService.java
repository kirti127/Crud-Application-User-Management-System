package com.spring_project.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_project.user.model.User;

@Service
public interface UserService {
    // --------create user -----

    public User createUser(User user);

    // ------- read user--------

    public List<User> getUsers();

    // -------- read user by id -------

    public User getUserById(long id);

    // ------ delete user by id --------

    public void deleteUser(long id);

    // ------- update user by id ------

    public User updateUser(User user, long id);
}
