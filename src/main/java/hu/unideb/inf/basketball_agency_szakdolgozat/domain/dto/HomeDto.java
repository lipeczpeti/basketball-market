package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
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

    private List<Player> players;
    private List<Coach> coaches;
    private List<Team> teams;

}
