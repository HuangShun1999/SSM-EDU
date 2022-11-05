package com.mycode.controller;

import com.mycode.domain.RespondData;
import com.mycode.domain.User;
import com.mycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired()
    private UserService userService;

    @PostMapping("/login")
    public RespondData login(@RequestBody User user){
        try {
            User login = userService.login(user);
            return RespondData.success(login);
        }catch (Exception e){
            e.printStackTrace();
            return RespondData.error(e.getMessage());
        }
    }
}
