package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full;


import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.UserMiniDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class CountryDto {
    private int id;
    private String name;

    private List<UserMiniDto> users;
}
