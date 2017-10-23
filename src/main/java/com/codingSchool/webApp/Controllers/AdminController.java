package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Services.RepairServiceImpl;
import com.codingSchool.webApp.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RepairServiceImpl repairService;

    private String REPAIR_LIST = "repairList";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);


    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String admin(Model model) {
        logger.info("Into the admin page controller");
        model.addAttribute("message", "Hello Admin");
        model.addAttribute(REPAIR_LIST, repairService.findTop10ByOrderByDatetime());
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
