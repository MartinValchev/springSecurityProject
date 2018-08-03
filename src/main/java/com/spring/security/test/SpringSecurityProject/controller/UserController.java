package com.spring.security.test.SpringSecurityProject.controller;

import com.spring.security.test.SpringSecurityProject.config.Errors;
import com.spring.security.test.SpringSecurityProject.models.RegistrationModel;
import com.spring.security.test.SpringSecurityProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegistrationModel registrationModel){
            return "register";
    }

    @PostMapping("/register")
    public String registerPage(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        this.userService.register(registrationModel);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error !=null) {
            model.addAttribute("error", Errors.INVALID_CREDENTIALS);
        }
        return  "login";
    }
}
