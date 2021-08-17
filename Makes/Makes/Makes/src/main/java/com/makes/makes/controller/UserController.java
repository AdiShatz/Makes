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
   public User signIn(@RequestBody User user)
    {
        Optional<User> existUser = userService.findByEmail(user.getEmail());
        
        if(existUser.isPresent()==true)
        {
            if (user.getPassword().equals(existUser.get().getPassword())==false)
            {
                user.setError("סיסמא שגוייה. אנא נסה שוב");
                
            }
        }
        else
        {
            user.setError("מצטערים, לא נמצא משתמש כזה במערכת");
        }


        return existUser.get();
    }

    @PostMapping("/joinUs")
    public User register(@RequestBody User user)
    {
        // if (user.getEmail()==null || user.getPassword() == null ||user.getUserName() == null)
        // {
        //     //return "All cells must be filled";
        // }

        Optional<User> existUser = userService.findByEmail(user.getEmail());

        if (existUser.isPresent() ==true)
        {
            //return user.getEmail() + " already exist";//TODO CHECK if i need to return a string
            user.setError("המשתמש כבר קיים");

        }
        // if (user.getPassword().length() < 6)
        // {
        //     return "Password must contain at least six characters";//TODO CHECK IF NEED
        // }
        else
        {
            userService.add(user);
            // return "You have successfully registered";//TODO CHECK if return string
        }

        return user;


    }

}

