package com.masatrio.springcrud.masatriospringbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.masatrio.springcrud.masatriospringbootcrud.persistence.User;
import com.masatrio.springcrud.masatriospringbootcrud.repository.UserRepository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/users")
    public List<User> findAll()
    {
    	InetAddress ip;
        String hostname;
        try {
	        ip = InetAddress.getLocalHost();
	        hostname = ip.getHostName();
	        System.out.print("hostname = "+hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return userRepository.findAll();
    }


    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    public Optional<User> findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findById(userId);
    }
}