package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LanguageDto {

    private int id;
    private String name;
}
