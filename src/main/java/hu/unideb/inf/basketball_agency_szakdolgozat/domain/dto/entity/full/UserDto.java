package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full;


import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.CoachMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.LanguageMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.PlayerMiniDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@ToString
public class UserDto {

    private int id;

    private String name;
    private String email;

    private CountryDto country;

    private Date date;

    private List<LanguageMiniDto> languages;

    private String password;
    private File avatar;
    private boolean approved;
    private boolean active;

    private List<CoachMiniDto> coach;

    private List<PlayerMiniDto> player;
}
