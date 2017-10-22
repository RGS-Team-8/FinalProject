package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Converters.UserConverter;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.InsertForm;
import com.codingSchool.webApp.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class InsertController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(InsertController.class);
    private static final String INSERT_FORM = "insertForm";

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/admin/owner/insert", method = RequestMethod.GET)
    public String insert(Model model) {
        model.addAttribute(INSERT_FORM, new InsertForm());
        return "insert";
    }

    @RequestMapping(value="/admin/owner/insert", method = RequestMethod.POST)
    public String insert(@Valid @ModelAttribute(INSERT_FORM)
                                     InsertForm insertForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "insert";
        }

        try {
            User user = UserConverter.buildUserObject(insertForm);
            userService.insert(user);
            session.setAttribute("username", insertForm.getUserid());

        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("User registration failed: " + exception);
            return "/insert";
        }
        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "/insert";
    }
}