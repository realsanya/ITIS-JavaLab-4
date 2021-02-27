package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.interfaces.SignUpService;
import ru.itis.javalab.services.interfaces.UserService;

import java.io.IOException;

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
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String register(UserForm userForm) throws IOException {
        System.out.println(userForm);
        if (userService.userIsExist(userForm.getEmail())){
            return "redirect:/login";
        }
        if (signUpService.signUp(userForm)) {
            return "redirect:/main";
        } else {
            return "redirect:/signUp";
        }
//        request.setCharacterEncoding("UTF-8");
//        String firstNameFromRequest = request.getParameter("first_name");
//        String lastNameFromRequest = request.getParameter("last_name");
//        String emailFromRequest = request.getParameter("email");
//        String passwordFromRequest = request.getParameter("password");
//        String passwordAgainFromRequest = request.getParameter("password_again");
//
//        if (Validator.validRegisterData(firstNameFromRequest, lastNameFromRequest, emailFromRequest,
//                passwordFromRequest, passwordAgainFromRequest)) {
//            System.out.println("valid");
//            String hashPassword = passwordEncoder.encode(passwordFromRequest);
//
//            if (userService.userIsExist(email)) {
//                return "redirect:/login";
//            } else {
//                System.out.println(firstNameFromRequest + lastNameFromRequest + emailFromRequest + passwordFromRequest);
//                User user = User.builder()
//                        .first_name(firstNameFromRequest)
//                        .last_name(lastNameFromRequest)
//                        .email(emailFromRequest)
//                        .password(hashPassword)
//                        .image_id(imageService.getImage(1))
//                        .build();
//                userService.addUser(user);
//
//                request.getSession().setAttribute("user", userService.getUser(user.getEmail()));
//                return "redirect:/profile";
//            }
//        } else {
//            return "redirect:/login";
//        }
    }
}
