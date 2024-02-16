package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.CountryMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMiniDtoTransformer {
    public CountryMiniDto tranform(Country country){
        return CountryMiniDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}
