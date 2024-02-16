package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Hand;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/regisztracio")
    public String registrationForm(){
        return "regisztracio";
    }

    @PostMapping(value = "/regisztracio")
    public String registrationProcess(HttpServletRequest request){
        System.out.println(request.getParameter("username"));
        if(request.getParameter("userType").equals("coach")){
            registrationService.registeredCoach(request.getParameter("username"),request.getParameter("password1"),request.getParameter("password2"),request.getParameter("email"),null,request.getParameter("birthday"),request.getParameter("phoneNumber"), null);
        }else{
            registrationService.registeredPlayer(request.getParameter("username"),request.getParameter("password1"),request.getParameter("password2"),request.getParameter("email"),null,request.getParameter("birthday"),Integer.parseInt(request.getParameter("height")),Integer.parseInt(request.getParameter("weight")), Integer.parseInt(request.getParameter("position")),Integer.parseInt(request.getParameter("minSalary")), Hand.valueOf(request.getParameter("hand")),Boolean.parseBoolean(request.getParameter("contract")));
        }

        return "sikeres-regisztracio";
    }
}
