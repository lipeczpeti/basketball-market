package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoTransformer {
    public CountryDto tranform(Country country){
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }


}
