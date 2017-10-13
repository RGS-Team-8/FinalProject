package com.codingSchool.webApp.Controllers;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Into the main page controller");
        model.addAttribute("message", "Hello");

        addUsernameInModel(model);

        return "index";
    }

    private void addUsernameInModel(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            String username = (String) auth.getPrincipal();
            model.addAttribute("username", username);
        } else {
            model.addAttribute("errorMessage", "User not logged in anymore!");
        }

    }

}