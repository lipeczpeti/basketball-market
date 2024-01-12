package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public void getHome(){
        
    }
}
