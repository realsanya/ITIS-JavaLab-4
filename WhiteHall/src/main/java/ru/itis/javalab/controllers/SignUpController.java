package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.interfaces.SignUpService;
import ru.itis.javalab.services.interfaces.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;

@Controller
public class SignUpController {

    public final SignUpService signUpService;
    public final UserService userService;

    @Autowired
    public SignUpController(SignUpService signUpService, UserService userService) {
        this.signUpService = signUpService;
        this.userService = userService;
    }

    @RequestMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String register(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        System.out.println(userForm);
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                System.out.println(Arrays.toString(error.getCodes()));
                if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidNames")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
                if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidPasswords")) {
                    model.addAttribute("passwordsErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("userForm", userForm);
            return "sign_up";
        } else if (userService.userIsExist(userForm.getEmail())) {
            return "redirect:/login";
        } else if (signUpService.signUp(userForm)) {
            // TODO изменить на профиль
            return "redirect:/login";
        } else {
            return "redirect:/signUp";
        }
    }
}
