package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.File;

@Builder
@Getter
@ToString
public class CoachDto {
    private int id;
    private String phoneNumber;
    private File cv;

    private UserDto user;
}
