package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoTransformer {

    private UserMiniDtoTransformer userMiniDtoTransformer;
    public CountryDto transform(Country country){
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .users(userMiniDtoTransformer.transformList(country.getUsers()))
                .build();
    }


}
