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
    public static final String EMAIL_OR_SSN_LIST = "emailsorssns";

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/admin/owner/search", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "search";
    }

    @RequestMapping(value="/admin/owner/search", method = RequestMethod.POST)
    public String search(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {

        List emailorssnList = userService.findByEmailOrSsn(searchForm.getEmail(), searchForm.getSsn());

        if(emailorssnList.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No user Found");

            return "redirect:search";
        }

        redirectAttributes.addFlashAttribute(EMAIL_OR_SSN_LIST, emailorssnList);

        return "redirect:search";
    }

    @RequestMapping(value="/admin/owner/update", method = RequestMethod.POST)
    public String update(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        User user = UserUpdater.updateUserObject(searchForm);
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>UPDATE User with UserId:" + user.getUserid());
        userService.update(user);
        session.setAttribute("username", searchForm.getUserid());

        return "redirect:search";
    }

    @RequestMapping(value="/admin/owner/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DELETE User with UserId:" + searchForm.getUserid());
        userService.delete(searchForm.getUserid());

        return "redirect:search";
    }

}
