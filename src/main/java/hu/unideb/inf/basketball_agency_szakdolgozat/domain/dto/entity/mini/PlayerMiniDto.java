package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.UserDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Hand;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PlayerMiniDto {
    private int id;
    private int height;
    private int weight;
    private int position;
    private int minSalary;
    private Hand hand;
    private boolean contract;
}
