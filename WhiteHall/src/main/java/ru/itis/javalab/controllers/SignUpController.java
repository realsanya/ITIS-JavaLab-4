package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.SignUpService;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;


@Controller
public class SignUpController {

    public final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "sign_up";
    }

    @ModelAttribute("userForm")
    public UserForm getUserForm() {
        return new UserForm();
    }

    @PostMapping("/signUp")
    public String register(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult, Model model) {
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
        } else if (signUpService.signUp(userForm)) {
            return "redirect:/main";
        } else {
            return "redirect:/signIn";
        }
    }
}