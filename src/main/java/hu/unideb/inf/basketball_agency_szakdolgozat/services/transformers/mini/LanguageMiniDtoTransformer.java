package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.LanguageDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.LanguageMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Language;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LanguageMiniDtoTransformer {
    public LanguageMiniDto transform(Language language){
        return LanguageMiniDto.builder()
                .id(language.getId())
                .name(language.getName())
                .build();
    }

    public List<LanguageMiniDto> transform(List<Language> languages){
        List<LanguageMiniDto> result = new ArrayList<>();

        for(Language language : languages){
            result.add(transform(language));
        }
        return result;
    }
}
