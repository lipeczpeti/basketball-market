package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.TeamDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Team;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HomeDto {
    private long coach;
    private long player;
    private long club;

    private List<PlayerDto> players;
    private List<CoachDto> coaches;
    private List<TeamDto> teams;
    private List<CountryDto> countries;

}
