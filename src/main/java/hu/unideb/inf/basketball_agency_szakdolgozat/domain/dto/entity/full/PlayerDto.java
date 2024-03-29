package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.TeamMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.UserMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Hand;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class PlayerDto {

    private int id;
    private int height;
    private int weight;
    private int position;
    private int minSalary;
    private Hand hand;
    private boolean contract;

    private UserMiniDto user;
    private TeamMiniDto team;
}
