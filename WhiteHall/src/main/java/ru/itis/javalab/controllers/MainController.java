package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "/stages", method = RequestMethod.GET)
    public String getStagesPage() {
        return "stages";
    }

    @RequestMapping(value = "/advantages", method = RequestMethod.GET)
    public String getAdvantagesPage() {
        return "advantages";
    }

    @RequestMapping(value = "/gift", method = RequestMethod.GET)
    public String getGiftPage() {
        return "gift";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String getServicesPage() {
        return "services";
    }
}
