package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("unapprovedUsers", adminService.getAdminPageData());

        return "admin";
    }

    @PostMapping(path = "/admin/felhasznalo-jovahagyas")
    public String approveUser(Model model, @RequestParam(required = false) int userId) {
        model.addAttribute("successApprove", adminService.approveUser(userId));
        model.addAttribute("unapprovedUsers", adminService.getAdminPageData());

        return "admin";

    }

    @PostMapping(path = "/admin/felhasznalo-torles")
    public String deleteUser(Model model, @RequestParam(required = false) int userId) {
        model.addAttribute("successDelete", adminService.deleteUser(userId));
        model.addAttribute("unapprovedUsers", adminService.getAdminPageData());

        return "admin";

    }
}
