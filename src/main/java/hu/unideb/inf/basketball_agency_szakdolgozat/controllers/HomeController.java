package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @Autowired
    private CoachRepository coachRepository;

    @GetMapping(path = "/")
    public String home(){
        System.out.println(coachRepository.count());
        return "index";
    }

}
