package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);

    private String REPAIR_LIST = "repairList";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/home", method = RequestMethod.GET)
    public String user(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        List<User> users = userService.findByEmail(mail);
        System.err.println("Repairs for user " + users.get(0).getUserid());
        model.addAttribute(REPAIR_LIST, users.get(0).getRepairs());
        return "user";
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