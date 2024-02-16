package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.CoachMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.UserDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CoachMiniDtoTransformer {
    public CoachMiniDto transform(Coach coach){
        return CoachMiniDto.builder()
                .id(coach.getId())
                .phoneNumber(coach.getPhoneNumber())
                .cv(coach.getCv())
                .build();
    }


    public List<CoachMiniDto> transformList(List<Coach> coaches){
        List<CoachMiniDto> result = new ArrayList<>();

        for(Coach coach : coaches){
            result.add(transform(coach));
        }
        return result;
    }
}
