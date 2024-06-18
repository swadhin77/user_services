package com.assessment.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.user_service.model.User;
import com.assessment.user_service.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User res=userService.createUser(user);
        
        return new ResponseEntity<User>(res, HttpStatus.CREATED);
    }


    @GetMapping("/fetch")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getUsers(){
      List<User> list=  userService.getAllUsers();     
      return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getUsers(@PathVariable int id){
      User user=  userService.getUser(id);

     
      return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
