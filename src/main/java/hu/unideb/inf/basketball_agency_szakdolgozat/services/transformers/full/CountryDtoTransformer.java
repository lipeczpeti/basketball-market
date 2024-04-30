package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDtoTransformer {

    private UserMiniDtoTransformer userMiniDtoTransformer;

    public CountryDtoTransformer(UserMiniDtoTransformer userMiniDtoTransformer) {
        this.userMiniDtoTransformer = userMiniDtoTransformer;
    }


    public CountryDto transform(Country country){
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .users(userMiniDtoTransformer.transformList(country.getUsers()))
                .build();
    }

    public List<CountryDto> transform(List<Country> countries) {
        List<CountryDto> result = new ArrayList<>();

        for (Country country : countries) {
            result.add(transform(country));
        }

        return result;
    }


}
