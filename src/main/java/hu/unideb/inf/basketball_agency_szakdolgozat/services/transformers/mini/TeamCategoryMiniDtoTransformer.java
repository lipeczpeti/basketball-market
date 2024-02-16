package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.TeamCategoryMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.TeamCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamCategoryMiniDtoTransformer {

    public TeamCategoryMiniDto transform(TeamCategory teamCategory){
        return TeamCategoryMiniDto.builder()
                .id(teamCategory.getId())
                .name(teamCategory.getName())
                .build();
    }

    public List<TeamCategoryMiniDto> transformList(List<TeamCategory> teamCategories){
        List<TeamCategoryMiniDto> result = new ArrayList<>();
        for(TeamCategory teamCategory : teamCategories){
            result.add(transform(teamCategory));
        }
        return result;
    }
}
