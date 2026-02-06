package com.example.travelsite.controller;

import com.example.travelsite.dto.UserForm;
import com.example.travelsite.entity.User;
import com.example.travelsite.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "security/register";
    }

    @PostMapping("/register")
    public String register(UserForm form, Model model) {

        //adminユーザー登録禁止
        if(form.getUsername().equalsIgnoreCase("admin")){
            model.addAttribute("usernameError", "このユーザーは使用できません");
            //入力欄クリア
            form.setUsername("");
            form.setEmail("");
            return "security/register";
        }

        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setRole("ROLE_USER");

        userService.register(user);

        return "redirect:/login";
    }
}
