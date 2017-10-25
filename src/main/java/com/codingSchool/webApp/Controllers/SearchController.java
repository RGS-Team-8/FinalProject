package com.codingSchool.webApp.Controllers;

import com.codingSchool.webApp.Converters.RepairUpdater;
import com.codingSchool.webApp.Converters.UserUpdater;
import com.codingSchool.webApp.Converters.VehicleUpdater;
import com.codingSchool.webApp.Domain.Repair;
import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Domain.Vehicle;
import com.codingSchool.webApp.Model.SearchForm;
import com.codingSchool.webApp.Model.SearchRepairForm;
import com.codingSchool.webApp.Model.SearchVehicleForm;
import com.codingSchool.webApp.Services.RepairService;
import com.codingSchool.webApp.Services.UserService;
import com.codingSchool.webApp.Services.VehicleService;
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
    private static final String SEARCH_VEHICLE_FORM="searchVehicleForm";
    private static final String VEHICLE_LIST="vehicleList";

    @Autowired
    private UserService userService;

    @Autowired
    private RepairService repairService;

    @Autowired
    private VehicleService vehicleService;

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
        List<Repair> repairs = repairService.findByDatetime(searchRepairForm.getDatetime());
        List<Repair> repair1=repairService.findByDatetimeAfterAndDatetimeBefore(searchRepairForm.getDatetime(),searchRepairForm.getDatetime());
        if(users.isEmpty() && repairs.isEmpty() && repair1.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No user Found");

            return "redirect:searchRepair";
        }
        if(!users.isEmpty()) {
            System.err.println("SEARCH: Repair search via SSN");
            model.addAttribute(REPAIR_LIST, users.get(0).getRepairs());
            System.err.println(users.get(0).getRepairs());
            redirectAttributes.addFlashAttribute(REPAIR_LIST, users.get(0).getRepairs());

            return "redirect:searchRepair";
        }

        System.err.println("SEARCH: Repair search via Datetime");
        redirectAttributes.addFlashAttribute(REPAIR_LIST, repairs);

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


    ///////////////////////////VEHICLE------------------////////////////


    @RequestMapping(value ="/admin/vehicle/searchVehicle", method = RequestMethod.GET)
    public String searchVehicle(Model model) {
        model.addAttribute(SEARCH_VEHICLE_FORM, new SearchVehicleForm());

        return "searchVehicle";
    }

    @RequestMapping(value="/admin/vehicle/searchVehicle", method = RequestMethod.POST)
    public String searchVehicle(Model model, @ModelAttribute(SEARCH_VEHICLE_FORM) SearchVehicleForm searchVehicleForm,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        List<User> users = userService.findBySsn(searchVehicleForm.getSsn());
        List<Vehicle> vehicles = vehicleService.findByPlate(searchVehicleForm.getPlate());
        if(users.isEmpty() && vehicles.isEmpty() ) {
            redirectAttributes.addFlashAttribute("errorMessage", "No user Found");

            return "redirect:searchVehicle";
        }
        if(!users.isEmpty()) {
            System.err.println("SEARCH: Vehicle search via SSN");
            model.addAttribute(VEHICLE_LIST, users.get(0).getVehicles());
            System.err.println(users.get(0).getVehicles());
            redirectAttributes.addFlashAttribute(VEHICLE_LIST, users.get(0).getVehicles());

            return "redirect:searchVehicle";
        }

        System.err.println("SEARCH: Vehicle search via Plate");
        redirectAttributes.addFlashAttribute(VEHICLE_LIST, vehicles);

        return "redirect:searchVehicle";
    }

    @RequestMapping(value="/admin/vehicle/updateVehicle", method = RequestMethod.POST)
    public String updateVehicle(@ModelAttribute(SEARCH_VEHICLE_FORM) SearchVehicleForm searchVehicleForm,
                               BindingResult bindingResult, HttpSession session,
                               RedirectAttributes redirectAttributes) {
        Vehicle vehicle = VehicleUpdater.updateVehicleObject(searchVehicleForm);
        System.err.println("UPDATE: Vehicle belongs to user with UserId: " + vehicle.getId());
        vehicleService.update(vehicle);

        return "redirect:searchVehicle";
    }


    @RequestMapping(value="/admin/vehicle/deleteVehicle", method = RequestMethod.POST)
    public String delete(@ModelAttribute(SEARCH_VEHICLE_FORM) SearchVehicleForm searchVehicleForm,
                         BindingResult bindingResult, HttpSession session,
                         RedirectAttributes redirectAttributes) {

        System.err.println("DELETE: Vehicle belongs to user with UserId: " + searchVehicleForm.getUserid());
        vehicleService.delete(searchVehicleForm.getId());

        return "redirect:searchVehicle";
    }



}
