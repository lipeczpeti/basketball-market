package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.CoachTableDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CoachDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private CoachDtoTransformer coachDtoTransformer;

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

        // TODO: Lenti egyenlet nem jó, egész szám esetén eggyel több page fog megjelenni.
        coachTableDto.setPages((coaches.size() / pageSize) + 1);

        return coachTableDto;
    }
}
