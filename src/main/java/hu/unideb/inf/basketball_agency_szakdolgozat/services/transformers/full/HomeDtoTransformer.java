package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.TeamDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.HomeDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeDtoTransformer {
    @Autowired
    private PlayerDtoTransformer playerDtoTransformer;
    @Autowired
    private CoachDtoTransformer coachDtoTransformer;
    @Autowired
    private TeamDtoTransformer teamDtoTransformer;

    public HomeDto transform(long coach, long player, long club, List<Player>players, List<Coach>coaches, List<Team>teams){
        HomeDto result = new HomeDto();
        result.setCoach(coach);
        result.setPlayer(player);
        result.setClub(club);
        result.setPlayers(playerDtoTransformer.transformWithDependenciesList(players));
        result.setTeams(teamDtoTransformer.transformWithDependenciesList(teams));
        result.setCoaches(coachDtoTransformer.transformWithDependenciesList(coaches));
        return result;
    }
}
