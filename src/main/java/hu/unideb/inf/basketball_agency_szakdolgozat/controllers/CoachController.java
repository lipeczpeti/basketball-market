package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.CoachTableDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.CoachService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.CoachMiniDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CoachController {
    @Autowired
    private CoachService coachService;
    @GetMapping(value = "/edzo")
    public String allCoach(
            Model model,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(required = false, defaultValue = "") String byName,
            @RequestParam(required = false, defaultValue = "-1") Integer byAgeMin,
            @RequestParam(required = false, defaultValue = "-1") Integer byAgeMax){

        CoachTableDto coachTable;
        if (byAgeMax != -1 || byAgeMin != -1 || !byName.equals("")) {


            // kereső logika
            coachTable = new CoachTableDto();
            coachTable.setPages(1);

        } else {
            coachTable = coachService.getCoachesByPages(page,pageSize);
        }

        model.addAttribute("coaches", coachTable.getCoaches());
        model.addAttribute("pages", coachTable.getPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalCoaches", coachTable.getTotalCoaches());

        return "edzo";
    }
}
