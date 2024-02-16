package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.TeamCategoryMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.TeamCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class TeamDto {
    private int id;
    private String name;
    private List<TeamCategoryMiniDto> teamCategories;
}
