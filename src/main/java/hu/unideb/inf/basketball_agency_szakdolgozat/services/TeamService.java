package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.TeamDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.TeamRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.TeamDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamDtoTransformer teamDtoTransformer;

    public List<TeamDto> findAll() {
        return teamRepository.findAll()
                .stream()
                .map(team -> teamDtoTransformer.transformWithDependencies(team))
                .toList();
    }
}
