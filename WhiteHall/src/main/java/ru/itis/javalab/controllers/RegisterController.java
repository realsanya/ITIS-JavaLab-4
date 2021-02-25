package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.interfaces.ImageService;
import ru.itis.javalab.services.interfaces.UserService;
import ru.itis.javalab.utils.Validator;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class RegisterController {

    public final PasswordEncoder passwordEncoder;
    public final UserService userService;
    public final ImageService imageService;

    @Autowired
    public RegisterController(PasswordEncoder passwordEncoder, UserService userService, ImageService imageService){
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.imageService = imageService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request,
                          @RequestParam String first_name,
                          @RequestParam String last_name,
                          @RequestParam String email,
                          @RequestParam String password,
                          @RequestParam String password_again) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String firstNameFromRequest = request.getParameter("first_name");
        String lastNameFromRequest = request.getParameter("last_name");
        String emailFromRequest = request.getParameter("email");
        String passwordFromRequest = request.getParameter("password");
        String passwordAgainFromRequest = request.getParameter("password_again");

        if (Validator.validRegisterData(firstNameFromRequest, lastNameFromRequest, emailFromRequest,
                passwordFromRequest, passwordAgainFromRequest)) {
            System.out.println("valid");
            String hashPassword = passwordEncoder.encode(passwordFromRequest);

            if (userService.userIsExist(email)) {
                return "redirect:/login";
            } else {
                System.out.println(firstNameFromRequest + lastNameFromRequest + emailFromRequest + passwordFromRequest);
                User user = User.builder()
                        .first_name(firstNameFromRequest)
                        .last_name(lastNameFromRequest)
                        .email(emailFromRequest)
                        .password(hashPassword)
                        .image_id(imageService.getImage(1))
                        .build();
                userService.addUser(user);

                request.getSession().setAttribute("user", userService.getUser(user.getEmail()));
                return "redirect:/profile";
            }
        } else {
            return "redirect:/login";
        }
    }
}
