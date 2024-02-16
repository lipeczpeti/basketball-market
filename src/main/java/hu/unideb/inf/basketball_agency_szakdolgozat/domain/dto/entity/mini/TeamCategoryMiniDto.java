package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class TeamCategoryMiniDto {
    private int id;
    private String name;
}
