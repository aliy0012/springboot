package com.ums;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UsersResource {

    private UsersRepository usersRepository;


    public UsersResource(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    //get specific user
    @GetMapping(path = "/users/{identity}")
    public User getUser(@PathVariable("identity") Integer id) {

        return usersRepository.findById(id).get();
    }

    //post a user
    @PostMapping("/create-user/")
    public User createUser(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String email= body.get("email");
        String password = body.get("password");
        String role = body.get("role");

        User newUser = new User(name, email, password, role);
        return usersRepository.save(newUser);
    }

    //delete user
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        if(usersRepository.findById(id).equals(Optional.empty())) {
            return false;
        }
        usersRepository.deleteById(id);
        return true;
    }

    //get subscribers



}
