package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.CoachTableDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CoachDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoachDtoTransformer coachDtoTransformer;

    public List<Coach> getCoachesByNameAndMinAgeAndMaxAge(String name, int ageMin, int ageMax) {

        /*
            FORM:
            agemin: 0
            agemax: 24

            REPOSITORY:
            start: 2000 (mostani dátum - agemax)
            end: 2024 (mustani dátum - agemin)

            https://www.callicoder.com/how-to-add-subtract-days-hours-minutes-seconds-to-date-java/
            https://www.studytonight.com/java-examples/java-localdate-minusyears-method   <--- jobb
         */

        Date startDate;


        return null;
    }

    public CoachTableDto getCoachesByPages(int page, final int pageSize){
        final int finalPage = page-1;

        List<Coach> coaches = coachRepository.findAll();
        List<CoachDto> paginatedCoaches = IntStream.range(finalPage*pageSize,(finalPage*pageSize)+pageSize)
                .mapToObj(index-> index < coaches.size() ? coaches.get(index) : null)
                .filter(coach -> coach != null)
                .map(coach -> coachDtoTransformer.transformWithDependencies(coach))
                .toList();

        CoachTableDto coachTableDto = new CoachTableDto();
        coachTableDto.setCoaches(paginatedCoaches);
        coachTableDto.setTotalCoaches(coaches.size());

        double pages = (double) coaches.size() / pageSize;
        if (pages % 1 == 0) {
            coachTableDto.setPages(coaches.size() / pageSize);
        } else {
            coachTableDto.setPages((coaches.size() / pageSize) + 1);
        }


        return coachTableDto;
    }
}
