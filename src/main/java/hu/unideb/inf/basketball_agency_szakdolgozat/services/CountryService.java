package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CountryRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CountryDtoTransformer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryDtoTransformer transformer;

    public CountryService(CountryRepository countryRepository, CountryDtoTransformer transformer) {
        this.countryRepository = countryRepository;
        this.transformer = transformer;
    }

    public List<CountryDto> findAll() {
        return transformer.transform(countryRepository.findAll());
    }

}
