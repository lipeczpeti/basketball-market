package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.HomeDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.HomeDtoTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private HomeDtoTransformer homeDtoTransformer;

    public HomeDto getHome(){
        long coachCount = coachRepository.count();
        long playerCount = playerRepository.count();
        long clubCount = teamRepository.count();
        List<Player> players = playerRepository.findAll();
        List<Coach> coaches = coachRepository.findAll();
        List<Team> teams = teamRepository.findAll();

        HomeDto result = homeDtoTransformer.transform(coachCount,playerCount,clubCount,players,coaches,teams);



        return result;
    }

}
