package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Hand;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.CountryService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.RegistrationService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.TeamService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/regisztracio")
    public String registrationForm(Model model) {
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("countries", countryService.findAll());

        return "regisztracio";
    }

    @PostMapping(value = "/regisztracio")
    public String registrationProcess(HttpServletRequest request, Model model, @RequestParam(name = "profile") MultipartFile profilKep, @RequestParam(name = "cv", required = false) MultipartFile cv) {

        String result;
        if(request.getParameter("userType").equals("coach")){
            result = registrationService.registeredCoach(
                    request.getParameter("username"),
                    request.getParameter("password1"),
                    request.getParameter("password2"),
                    request.getParameter("email"),
                    profilKep,
                    request.getParameter("birthday"),
                    request.getParameter("phoneNumber"),
                    cv,
                    Integer.parseInt(request.getParameter("country")));
        }else{
            result = registrationService.registeredPlayer(
                    request.getParameter("username"),
                    request.getParameter("password1"),
                    request.getParameter("password2"),
                    request.getParameter("email"),
                    profilKep,
                    request.getParameter("birthday"),
                    Integer.parseInt(request.getParameter("height")),
                    Integer.parseInt(request.getParameter("weight")),
                    Integer.parseInt(request.getParameter("position")),
                    Integer.parseInt(request.getParameter("minSalary")),
                    Hand.valueOf(request.getParameter("hand")),
                    Boolean.parseBoolean(request.getParameter("contract")),
                    Integer.parseInt(request.getParameter("team")),
                    Integer.parseInt(request.getParameter("country")));
        }

        model.addAttribute("message", result);

        if (result.equals(RegistrationService.SUCCESS_MESSAGE)) {
            model.addAttribute("successfulRegistration", "true");
        } else {
            model.addAttribute("successfulRegistration", "false");
        }

        return "sikeres-regisztracio";
    }
}
