package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.LanguageDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Language;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LanguageDtoTransformer {
    public LanguageDto transform(Language language){
        return LanguageDto.builder()
                .id(language.getId())
                .name(language.getName())
                .build();
    }

    public List<LanguageDto> transform(List<Language> languages){
        List<LanguageDto> result = new ArrayList<>();

        for(Language language : languages){
            result.add(transform(language));
        }
        return result;
    }
}
