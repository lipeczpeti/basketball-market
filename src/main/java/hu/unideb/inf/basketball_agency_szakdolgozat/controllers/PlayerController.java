package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.CoachTableDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.PlayerPageDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/jatekos")
    public String allPlayer( Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                             @RequestParam(required = false, defaultValue = "") String byName,
                             @RequestParam(required = false, defaultValue = "0") Integer byAgeMin,
                             @RequestParam(required = false, defaultValue = "99") Integer byAgeMax){

        PlayerPageDto players;
        if (byAgeMax != 99 || byAgeMin != 0 || !byName.isEmpty()) {
            players = playerService.getPlayersByNameAndMinAgeAndMaxAge(byName, byAgeMin, byAgeMax, pageSize);

        } else {
           players = playerService.getPlayersByPage(page, pageSize);
        }

        model.addAttribute("players", players.getPlayers());
        model.addAttribute("pages", players.getPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPlayers", players.getTotalPlayers());
        model.addAttribute("byName", byName);
        model.addAttribute("byAgeMin", byAgeMin);
        model.addAttribute("byAgeMax", byAgeMax);

        return "jatekos";
    }



}
