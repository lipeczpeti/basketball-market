package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.security.UserAdapter;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.CountryService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.PlayerService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.ProfileSettingsService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.TeamService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.security.MySQLUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProfileSettingsController {

    private TeamService teamService;
    private CountryService countryService;
    private ProfileSettingsService profileSettingsService;

    @GetMapping(path = "/profile")
    public String profileModification(Model model, @RequestParam(defaultValue = "noError", required = false) String error, @AuthenticationPrincipal UserAdapter loggedInUser){
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("loggedInUser", loggedInUser);

        return "profileSettings";
    }

    @PostMapping(path = "/profile")
    public String profileModificationProcess(HttpServletRequest request, Model model, @RequestParam(defaultValue = "noError", required = false) String error, @AuthenticationPrincipal UserAdapter loggedInUser){
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("loggedInUser", loggedInUser);

        if (request.getParameter("type").equals("account_general")) {
            boolean isSuccessful
                    = profileSettingsService.updateUserDetails(loggedInUser.getUser().getId(), request.getParameter("username"), request.getParameter("email"), Integer.parseInt(request.getParameter("team")));


            model.addAttribute("general_info_error", isSuccessful ? "" : "Általános adatok módosítása sikertelen!");

        } else if (request.getParameter("type").equals("account_change_password")) {
            boolean isSuccessful
                    = profileSettingsService.updatePassword(loggedInUser.getUser().getId(), request.getParameter("old-password"), request.getParameter("new-password1"), request.getParameter("new-password2"));

            model.addAttribute("password_change_error", isSuccessful ? "" : "Jelszó módosítás sikertelen");

        } else if (request.getParameter("type").equals("account_info")) {
            boolean isSuccessful
                    = profileSettingsService.updateCountryAndBirthday(loggedInUser.getUser().getId(), Integer.parseInt(request.getParameter("country")), request.getParameter("birthday"));

            model.addAttribute("account_info_error", isSuccessful ? "" : " Személyes adatok módosítása sikertelen");
        }

        System.out.println(request.getParameter("type"));
        return "profileSettings";
    }
}
