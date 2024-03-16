package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.util.Date;

@Builder
@Getter
@ToString
public class UserMiniDto {
    private int id;
    private String name;
    private String email;
    private String date;
    private String password;
    private File avatar;
    private boolean approved;
    private boolean active;
}
