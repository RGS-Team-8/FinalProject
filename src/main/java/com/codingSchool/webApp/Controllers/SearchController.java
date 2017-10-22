package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Converters.UserUpdater;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.SearchForm;
import com.codingSchool.webApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController {
    private static final String SEARCH_FORM = "searchForm";
    public static final String EMAIL_LIST = "emails";
    public static final String SSN_LIST = "ssns";
    public static final String EMAIL_OR_SSN_LIST = "emailsorssns";

    public List emailList;

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/search", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "admin";
    }

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String search(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {

//        List emailList = userService.findByEmail(searchForm.getEmail());
//        List ssnList = userService.findBySsn(searchForm.getSsn());
        List emailorssnList = userService.findByEmailOrSsn(searchForm.getEmail(), searchForm.getSsn());

        if(emailorssnList.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No user Found");
            return "redirect:/admin/home";
        }

//        redirectAttributes.addFlashAttribute(EMAIL_LIST, emailList);
//        redirectAttributes.addFlashAttribute(SSN_LIST, ssnList);
        redirectAttributes.addFlashAttribute(EMAIL_OR_SSN_LIST, emailorssnList);

        return "redirect:/admin/home";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        User user = UserUpdater.updateUserObject(searchForm);
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>UPDATE User with UserId:" + user.getUserid());
        userService.update(user);
        session.setAttribute("username", searchForm.getUserid());

        return "redirect:/admin/home";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

//        User user = UserUpdater.updateUserObject(searchForm);
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DELETE User with UserId:" + searchForm.getUserid());
        userService.delete(searchForm.getUserid());
//        session.setAttribute("username", searchForm.getUserid());

        return "redirect:/admin/home";
    }

}
