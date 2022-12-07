package com.demo.user.service.controller;


import com.demo.user.service.VO.ResponseTemplate;
import com.demo.user.service.entity.User;
import com.demo.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws MessagingException {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }
}
