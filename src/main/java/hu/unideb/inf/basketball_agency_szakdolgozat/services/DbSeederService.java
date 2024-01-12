package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.*;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<TeamCategory> teamCategories = new ArrayList<>();
        teamCategories.add(teamCategory1);
        team1.setTeamCategories(teamCategories);
        teamRepository.save(team1);

        User user1 = new User();
        user1.setName("Ember");
        List<Language>languages=new ArrayList<>();
        languages.add(language1);
        user1.setLanguages(languages);
        user1.setCountry(country1);
        user1.setEmail("ember@ember.hu");
        user1.setDate(new Date());
        user1.setPassword("123");
        userRepository.save(user1);

        Coach coach1 = new Coach();
        coach1.setPhoneNumber("323232");
        coach1.setUser(user1);
        coachRepository.save(coach1);

        User user2 = new User();
        user2.setName("Ember2");
        user2.setCountry(country1);
        List<Language> languages2 = new ArrayList<>();
        languages.add(language1);
        user2.setLanguages(languages2);
        user2.setEmail("2@ember2.hu");
        user2.setDate(new Date());
        user2.setPassword("1234");
        userRepository.save(user2);

        Player player1 = new Player();
        player1.setHand(Hand.RIGHT);
        player1.setHeight(190);
        player1.setPosition(2);
        player1.setMinSalary(120000);
        player1.setWeight(89);
        player1.setContract(true);
        player1.setUser(user2);
        playerRepository.save(player1);

    }
}
