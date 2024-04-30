package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
@Builder
@Getter
@ToString
public class CoachMiniDto {
    private int id;
    private String phoneNumber;
    private String cv;
}
