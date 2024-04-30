package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.HomeDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CountryRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.HomeDtoTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HomeService {

    private CoachRepository coachRepository;
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    private HomeDtoTransformer homeDtoTransformer;

    public HomeDto getHome(){
        long coachCount = coachRepository.count();
        long playerCount = playerRepository.count();
        long clubCount = teamRepository.count();
        List<Player> players = playerRepository.findFirst5ByOrderByIdDesc();
        List<Coach> coaches = coachRepository.findFirst5ByOrderByIdDesc();
        List<Team> teams = teamRepository.findFirst5ByOrderByIdDesc();

        return homeDtoTransformer.transform(coachCount,playerCount,clubCount,players,coaches,teams);
    }

}
