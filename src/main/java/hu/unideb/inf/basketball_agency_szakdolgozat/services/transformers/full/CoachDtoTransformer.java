package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CoachDtoTransformer {

    private UserMiniDtoTransformer userMiniDtoTransformer;

    public CoachDto transformWithDependencies(Coach coach){
        return CoachDto.builder()
                .id(coach.getId())
                .phoneNumber(coach.getPhoneNumber())
                .cv(coach.getCv())
                .user(userMiniDtoTransformer.transform(coach.getUser()))
                .build();
    }

    public List<CoachDto> transformWithDependenciesList(List<Coach> coaches){
        List<CoachDto> result = new ArrayList<>();
        for(Coach coach : coaches){
            result.add(transformWithDependencies(coach));
        }
        return result;
    }
}
