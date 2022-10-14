package com.example.lab2.controller.request;

import lombok.Setter;
import com.example.lab2.model.entities.User;

@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;


    public User toUser(){
        var user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setDateOfBirth(dateOfBirth);

        return user;
    }
}
