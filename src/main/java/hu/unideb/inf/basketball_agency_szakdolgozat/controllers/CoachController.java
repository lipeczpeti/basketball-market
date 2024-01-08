package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoachController {

    @GetMapping(value = "/edzo")
    public String allCoach(){
        return "edzo";
    }
}
