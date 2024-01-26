package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.HomeDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeDtoTransformer {

    public HomeDto transform(long coach, long player, long club, List<Player>players, List<Coach>coaches, List<Team>teams){
        HomeDto result = new HomeDto();
        result.setCoach(coach);
        result.setPlayer(player);
        result.setClub(club);
        result.setPlayers(players);
        result.setTeams(teams);
        result.setCoaches(coaches);
        return result;
    }
}
