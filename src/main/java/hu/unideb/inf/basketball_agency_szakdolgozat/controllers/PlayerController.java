package hu.unideb.inf.basketball_agency_szakdolgozat.controllers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.CoachTableDto;
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

        List<PlayerDto> players;
        if (byAgeMax != 99 || byAgeMin != 0 || !byName.isEmpty()) {
            players = playerService.getPlayersByNameAndMinAgeAndMaxAge(byName, byAgeMin, byAgeMax);

        } else {
           players = playerService.getPlayersByPage(page, pageSize);
        }

        double pages = (double) players.size() / pageSize;
        if (pages % 1 == 0) {
            pages = players.size() / pageSize;
        } else {
            pages += 1;
        }


        model.addAttribute("players", players);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPlayers", players.size() * pages);
        model.addAttribute("byName", byName);
        model.addAttribute("byAgeMin", byAgeMin);
        model.addAttribute("byAgeMax", byAgeMax);

        return "jatekos";
    }



}
