package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.*;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class RegistrationService {

    public static final String SUCCESS_MESSAGE = "Sikeres regisztráció!";
    public static final String PASSWORD_MISMATCH_MESSAGE = "Nem egyeznek a jelszavak!";
    public static final String USER_ALREADY_EXISTS = "Ezzel az email címmel már regisztráltak!";

    @Autowired
    UserRepository userRepository;
    @Autowired
    CoachRepository coachRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    ProfileSettingsService profileSettingsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public String registeredCoach(String userName, String password1, String password2, String email, MultipartFile file,String date, String phoneNumber, MultipartFile cv, int countryId){
        if (!password1.equals(password2)) {
            return PASSWORD_MISMATCH_MESSAGE;
        }
        User user = registered(userName,password1,password2,email,file,date, countryId);

        if (user == null) {
            return USER_ALREADY_EXISTS;
        }



        Coach coach = new Coach();
        coach.setPhoneNumber(phoneNumber);
        coach.setUser(user);

        profileSettingsService.uploadCv(coach, cv);

        coachRepository.save(coach);
        return SUCCESS_MESSAGE;
    }

    public String registeredPlayer(String userName, String password1, String password2, String email, MultipartFile file, String date, int height, int weight, int position, int minSalary, Hand hand, boolean contract, int teamId, int countryId){
        if (!password1.equals(password2)) {
            return PASSWORD_MISMATCH_MESSAGE;
        }
        User user = registered(userName,password1,password2,email,file,date, countryId);
        Team team = teamRepository.getReferenceById(teamId);

        if (user == null) {
            return USER_ALREADY_EXISTS;
        }

        Player player = new Player();
        player.setHeight(height);
        player.setWeight(weight);
        player.setPosition(position);
        player.setMinSalary(minSalary);
        player.setHand(hand);
        player.setContract(contract);
        player.setUser(user);
        player.setTeam(team);

        playerRepository.save(player);

        return SUCCESS_MESSAGE;
    }
    private User registered(String userName, String password1, String password2, String email, MultipartFile file,String date, int countryId){
        User userWithSameEmail = userRepository.findByEmail(email);

        if(userWithSameEmail == null && password1.equals(password2)) {
            Country country = countryRepository.findById(countryId).get();

            User user = new User();
            user.setName(userName);
            user.setPassword(passwordEncoder.encode(password1));
            user.setEmail(email);
            user.setActive(true);
            user.setCountry(country);
            try {
                user.setDate(simpleDateFormat.parse(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            user = userRepository.save(user);

            profileSettingsService.uploadPicture(user, file);

            return user;
        } else{
            return null;
        }
    }

}
