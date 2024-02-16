package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Hand;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CoachRepository coachRepository;
    @Autowired
    PlayerRepository playerRepository;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public boolean registeredCoach(String userName, String password1, String password2, String email, File file,String date, String phoneNumber, File cv){
        User user = registered(userName,password1,password2,email,file,date);
        Coach coach = new Coach();
        coach.setPhoneNumber(phoneNumber);
        coach.setCv(cv);
        coach.setUser(user);
        coachRepository.save(coach);
        return true;
    }

    public boolean registeredPlayer(String userName, String password1, String password2, String email, File file,String date, int height, int weight, int position, int minSalary, Hand hand,boolean contract){
        User user = registered(userName,password1,password2,email,file,date);
        Player player = new Player();
        player.setHeight(height);
        player.setWeight(weight);
        player.setPosition(position);
        player.setMinSalary(minSalary);
        player.setHand(hand);
        player.setContract(contract);
        player.setUser(user);
        playerRepository.save(player);
        return true;
    }
    private User registered(String userName, String password1, String password2, String email, File file,String date){
        if(password1.equals(password2)) {
            User user = new User();
            user.setName(userName);
            user.setPassword(password1);
            user.setEmail(email);
            user.setAvatar(file);
            try {
                user.setDate(simpleDateFormat.parse(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            return userRepository.save(user);
        } else{
            return null;
        }
    }

}
