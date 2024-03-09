package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CoachTableDto {

    private List<CoachDto> coaches;
    private int totalCoaches;
    private int pages;
}
