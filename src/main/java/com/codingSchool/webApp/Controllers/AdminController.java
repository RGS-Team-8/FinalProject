package com.codingSchool.webApp.Controllers;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String admin(Model model) {
        logger.info("Into the admin page controller");
        model.addAttribute("message", "Hello Admin");

        addUsernameInModel(model);

        return "admin";
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