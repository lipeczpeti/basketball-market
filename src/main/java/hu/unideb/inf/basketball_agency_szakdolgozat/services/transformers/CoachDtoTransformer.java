package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoachDtoTransformer {
    @Autowired
    private UserDtoTransformer userDtoTransformer;
    public CoachDto transform(Coach coach){
        return CoachDto.builder()
                .id(coach.getId())
                .phoneNumber(coach.getPhoneNumber())
                .cv(coach.getCv())
                .build();
    }


    public List<CoachDto> transformList(List<Coach> coaches){
        List<CoachDto> result = new ArrayList<>();

        for(Coach coach : coaches){
            result.add(transform(coach));
        }
        return result;
    }


    public CoachDto transformWithDependencies(Coach coach){
        return CoachDto.builder()
                .id(coach.getId())
                .phoneNumber(coach.getPhoneNumber())
                .cv(coach.getCv())
                .user(userDtoTransformer.transform(coach.getUser()))
                .build();
    }
}
