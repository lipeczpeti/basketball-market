package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class PlayerPageDto {

    private List<PlayerDto> players;
    private int totalPlayers;
    private int pages;
}
