package com.spring_project.user.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring_project.user.model.User;
import com.spring_project.user.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {
    @Autowired
    private UserService UserService;

    @GetMapping("/")
    public String helloworld(){
        return "Hello World";
    }

    // ----- Rest Api Create User - Post ------

    @PostMapping("/add")
    public User createUser(@RequestBody final User user){
        final User user1 = UserService.createUser(user);
        return user1;
    }

    // ------ Read User - Get -----------

    @GetMapping("/users")
    public List<User> getUsers(){
        return UserService.getUsers();
    }

    // ----- Delete User - Put ---------

    @PutMapping("/update/{id}")
    public User updateUserById(@RequestBody final User user, @PathVariable("id") final long id){
        return UserService.updateUser(user, id);
    }

    // ------ Update User - Put ---------

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") final long id){
        UserService.deleteUser(id);
        return "User Deleted Successfully..";
    }

    // ------ Get User by id -------

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") final long id){
        return UserService.getUserById(id);
    }

    
}