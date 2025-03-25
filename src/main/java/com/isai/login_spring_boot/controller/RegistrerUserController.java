package com.isai.login_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isai.login_spring_boot.dto.UserRequest;
import com.isai.login_spring_boot.service.impl.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/register")
public class RegistrerUserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRequest userRequest() {
        UserRequest user = new UserRequest();
        return user;
    }

    @GetMapping
    public String showFormRegistrer() {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRequest userRequest) {
        userService.saveUser(userRequest);
        return "redirect:/register?Exito";
    }

}
