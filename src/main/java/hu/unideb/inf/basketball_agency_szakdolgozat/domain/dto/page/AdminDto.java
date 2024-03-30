package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AdminDto {

    private List<PlayerDto> players;
    private List<CoachDto> coaches;
}
