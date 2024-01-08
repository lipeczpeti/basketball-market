package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.Country;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.Language;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.Team;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.TeamCategory;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbSeederService {
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamCategoryRepository teamCategoryRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void seed(){
        Country country1 = new Country();
        country1.setName("Hungary");
        countryRepository.save(country1);

        Language language1 = new Language();
        language1.setName("Hungarian");
        languageRepository.save(language1);

        TeamCategory teamCategory1 = new TeamCategory();
        teamCategory1.setName("NB1");
        teamCategoryRepository.save(teamCategory1);

        Team team1= new Team();
        team1.setName("BKG-Prima");
        teamRepository.save(team1);

    }
}
