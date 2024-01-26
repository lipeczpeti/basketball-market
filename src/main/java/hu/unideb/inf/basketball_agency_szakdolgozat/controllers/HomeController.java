package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.HomeDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping(path = "/")
    public String home(Model model){
        HomeDto dtoResult = homeService.getHome();
        model.addAttribute("homeData",dtoResult);
        return "index";
    }

}
