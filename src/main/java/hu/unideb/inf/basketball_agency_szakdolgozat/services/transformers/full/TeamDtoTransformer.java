package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.TeamDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.TeamCategoryMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.TeamCategoryMiniDtoTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TeamDtoTransformer {
    private TeamCategoryMiniDtoTransformer teamCategoryMiniDtoTransformer;

    public TeamDto transformWithDependencies(Team team){
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .teamCategories(teamCategoryMiniDtoTransformer.transformList(team.getTeamCategories()))
                .build();
    }

    public List<TeamDto> transformWithDependenciesList(List<Team> teams){
        List<TeamDto> result = new ArrayList<>();
        for (Team team : teams){
            result.add(transformWithDependencies(team));
        }
        return result;
    }
}
