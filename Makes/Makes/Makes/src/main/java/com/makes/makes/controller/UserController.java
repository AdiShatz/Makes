package com.makes.makes.controller;


import com.makes.makes.model.User;
import com.makes.makes.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/authentication")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;

    }

   @PostMapping("/signIn")
   public String signIn(@RequestBody User user)
    {
        Optional<User> existUser = userService.findByEmail(user.getEmail());

        if(existUser.isPresent()==true)
        {
            if (user.getPassword().equals(existUser.get().getPassword())==false)
            {
                return "Password doesn't match";//TODO CHECK return string?
            }
            if (user.getUserName().equals(existUser.get().getUserName())==false)
            {
                return "User name doesn't match";//TODO CHECK return string?
            }
            else
            {
                return existUser.get().getId();
            }
        }
        else
        {
            return "User doesn't exist";//TODO CHECK if i need to return a string
        }
    }

    @PostMapping("/joinUs")
    public String register(@RequestBody User user)
    {

        Optional<User> existUser = userService.findByEmail(user.getEmail());

        if (existUser.isPresent() ==true)
        {
            return user.getEmail() + " already exist";//TODO CHECK if i need to return a string
        }
        if (user.getPassword().length() < 6)
        {
            return "Password must contain at least six characters";//TODO CHECK IF NEED
        }
        else
        {
            userService.add(user);
            return "You have successfully registered";//TODO CHECK if return string
        }

    }

}

