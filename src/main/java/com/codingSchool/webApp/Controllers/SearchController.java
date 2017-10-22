package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Converters.UserUpdater;
import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.SearchForm;
import com.codingSchool.webApp.Model.SearchRepairForm;
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
    private static final String SEARCH_REPAIR_FORM = "searchRepairForm";
    public static final String EMAIL_OR_SSN_LIST = "emailsorssns";
    private String REPAIR_LIST = "repairList";

    Repair repair;

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
        List emailorssnList = userService.findByEmailOrSsn(searchForm.getEmail(), searchForm.getSsn());
        if(emailorssnList.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No user Found");
            return "redirect:/admin/home";
        }
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

        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DELETE User with UserId:" + searchForm.getUserid());
        userService.delete(searchForm.getUserid());
        return "redirect:/admin/home";
    }

    @RequestMapping(value ="/search2", method = RequestMethod.GET)
    public String searchRepair(Model model) {
        model.addAttribute(SEARCH_REPAIR_FORM, new SearchRepairForm());
        return "admin";
    }

    @RequestMapping(value="/search2", method = RequestMethod.POST)
    public String searchRepair(Model model, @ModelAttribute(SEARCH_REPAIR_FORM) SearchRepairForm searchRepairForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {
        List<User> users = userService.findBySsn(searchRepairForm.getSsn());
        if(users.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No user Found");
            return "redirect:/admin/home";
        }
        model.addAttribute(REPAIR_LIST,users.get(0).getRepairs());
        return "showRepairs";
    }
}
