package com.example.lab2.controller;

import com.example.lab2.controller.request.UserRequest;
import com.example.lab2.controller.response.UserResponse;
import com.example.lab2.model.entities.User;
import com.example.lab2.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){}

    

    @PostMapping(path = "/sign-up", 
    consumes = "application/json",
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse signup(@RequestBody UserRequest userRequest) {
        var user = userRequest.toUser();
        System.out.println("+\n+\n+\n"+user.toString()+"\n+\n+\n+");

        return new UserResponse().fromUser(userService.create(user));
    }

    @PostMapping("/sign-in")
    public void signin(@RequestParam("email") String email, 
                        @RequestParam("password") String password) {
        userService.signin(email, password);
        System.out.println("sign-in");    
    }

    @PostMapping("/sign-out")
    public void signout(@RequestParam("id") String id) {
        userService.signout(id);
    }

    @GetMapping("/list-all")
    public List<User> getAll() {
        return userService.findAll();
    }

}
