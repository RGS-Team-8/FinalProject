package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Converters.RepairUpdater;
import com.codingSchool.webApp.Converters.UserUpdater;
import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.SearchForm;
import com.codingSchool.webApp.Model.SearchRepairForm;
import com.codingSchool.webApp.Services.RepairService;
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
    public static final String REPAIR_LIST = "repairList";

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

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

        System.err.println("Retrieve SSN from Search Form (Owner)");
        redirectAttributes.addFlashAttribute(EMAIL_OR_SSN_LIST, emailorssnList);
        System.err.println(emailorssnList);

        return "redirect:search";
    }

    @RequestMapping(value="/admin/owner/update", method = RequestMethod.POST)
    public String update(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        User user = UserUpdater.updateUserObject(searchForm);
        System.err.println("UPDATE: User with UserId:" + user.getUserid());
        userService.update(user);
        session.setAttribute("username", searchForm.getUserid());

        return "redirect:search";
    }

    @RequestMapping(value="/admin/owner/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        System.err.println("DELETE: User with UserId:" + searchForm.getUserid());
        userService.delete(searchForm.getUserid());

        return "redirect:search";
    }

    //=============== R E P A I R

    @RequestMapping(value ="/admin/repair/searchRepair", method = RequestMethod.GET)
    public String searchRepair(Model model) {
        model.addAttribute(SEARCH_REPAIR_FORM, new SearchRepairForm());

        return "searchRepair";
    }

    @RequestMapping(value="/admin/repair/searchRepair", method = RequestMethod.POST)
    public String searchRepair(Model model, @ModelAttribute(SEARCH_REPAIR_FORM) SearchRepairForm searchRepairForm,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        List<User> users = userService.findBySsn(searchRepairForm.getSsn());

        if (users.isEmpty()) {
            if (searchRepairForm.getDatetime2() == null) {
                List<Repair> repairs2 = repairService.findByDatetime(searchRepairForm.getDatetime());
                redirectAttributes.addFlashAttribute(REPAIR_LIST, repairs2);
                return "redirect:searchRepair";
            }
            List<Repair> repairs2 = repairService.findByDatetimeBetween(searchRepairForm.getDatetime(), searchRepairForm.getDatetime2());
            if (repairs2.isEmpty()) {
                redirectAttributes.addFlashAttribute("errorMessage", "No user Found");
                return "redirect:searchRepair";
            } else {
                System.err.println("SEARCH: Repair search via Range of Datetime");
                redirectAttributes.addFlashAttribute(REPAIR_LIST, repairs2);
                return "redirect:searchRepair";
            }
        }

        System.err.println("SEARCH: Repair search via SSN");
        model.addAttribute(REPAIR_LIST, users.get(0).getRepairs());
        System.err.println(users.get(0).getRepairs());
        redirectAttributes.addFlashAttribute(REPAIR_LIST, users.get(0).getRepairs());
        return "redirect:searchRepair";
    }

    @RequestMapping(value="/admin/repair/updateRepair", method = RequestMethod.POST)
    public String updateRepair(@ModelAttribute(SEARCH_REPAIR_FORM) SearchRepairForm searchRepairForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {
        Repair repair = RepairUpdater.updateRepairObject(searchRepairForm);
        System.err.println("UPDATE: Repair belongs to user with UserId: " + repair.getServiceid());
        repairService.update(repair);

        return "redirect:searchRepair";
    }

    @RequestMapping(value="/admin/repair/deleteRepair", method = RequestMethod.POST)
    public String delete(@ModelAttribute(SEARCH_REPAIR_FORM) SearchRepairForm searchRepairForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        System.err.println("DELETE: Repair belongs to user with UserId: " + searchRepairForm.getUserid());
        repairService.delete(searchRepairForm.getServiceid());
        return "redirect:searchRepair";
    }

}
