package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.TeamDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.TeamMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamMiniDtoTransformer {

    public TeamMiniDto transform(Team team){
        return TeamMiniDto.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }

    public List<TeamMiniDto> transformList(List<Team> teams){
        List<TeamMiniDto> result = new ArrayList<>();
        for (Team team : teams){
            result.add(transform(team));
        }
        return result;
    }
}
