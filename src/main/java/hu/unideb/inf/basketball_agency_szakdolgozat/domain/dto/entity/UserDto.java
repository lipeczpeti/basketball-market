package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity;


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

    private List<LanguageDto> languages;

    private String password;
    private File avatar;
    private boolean approved;
    private boolean active;

    private List<CoachDto> coach;

    private List<PlayerDto> player;
}
