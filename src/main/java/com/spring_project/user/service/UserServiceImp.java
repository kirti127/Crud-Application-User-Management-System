package com.spring_project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.user.model.User;
import com.spring_project.user.repository.UserRepository;



@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }
    
    @Override
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(long id){
        return  userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, long id){
        User user1 = userRepository.findById(id).get();
        user1.setEmail(user.getEmail());
        user1.setMobile(user.getMobile());
        user1.setAddress(user.getAddress());
        return userRepository.save(user1);
    }
}