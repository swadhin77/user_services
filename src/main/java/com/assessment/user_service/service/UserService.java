package com.assessment.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.user_service.exception.UserAlreadyExistsException;
import com.assessment.user_service.exception.UserNotFoundException;
import com.assessment.user_service.model.User;
import com.assessment.user_service.repository.UserRepository;

@Service
public class UserService {

    
    @Autowired
    private UserRepository userrepo;

    public User createUser(User user){

        if(userrepo.existsByUsername(user.getUsername())){
            throw new UserAlreadyExistsException("User already exist with username :"+user.getUsername());
        }

       User res= userrepo.save(user);
       return res;

    }




    public List<User> getAllUsers(){

       List<User> list= userrepo.findAll();
        if(list.isEmpty()) throw new UserNotFoundException("The User List is Empty..");

       return list;

    }

    public User getUser(int id){
        return userrepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id"+id));
    }

}
