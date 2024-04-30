package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.*;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileSettingsService {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);

    @Value("${basketball.market.avatar.folder}")
    private String pictureFolder;

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final CountryRepository countryRepository;
    private final PasswordEncoder passwordEncoder;
    private final CoachRepository coachRepository;

    public boolean updateUserDetails(int id, String name, String email, int teamId) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            Team team = teamRepository.findById(teamId).get();

            user.get().setName(name);
            user.get().setEmail(email);

            userRepository.save(user.get());

            Player player = user.get().getPlayer().get(0);
            player.setTeam(team);

            playerRepository.save(player);

            return true;
        }

        return false;
    }

    public boolean updatePassword(int id, String oldPassword, String newPassword1, String newPassword2) {
        if (!newPassword1.equals(newPassword2)) {
            return false;
        }

        Optional<User> user = userRepository.findByIdAndPassword(id, passwordEncoder.encode(oldPassword));

        if (user.isEmpty()) {
            return false;
        }

        user.get().setPassword(passwordEncoder.encode(newPassword1));
        userRepository.save(user.get());

        return true;
    }

    public boolean updateCountryAndBirthday(int id, int countryId, String date) {
        Optional<User> user = userRepository.findById(id);
        Optional<Country> country = countryRepository.findById(countryId);

        if (user.isEmpty() || country.isEmpty()) {
            return false;
        }

        Date birthday;
        try {
            birthday = formatter.parse(date);
        } catch (ParseException e) {
            return false;
        }

        user.get().setCountry(country.get());
        user.get().setDate(birthday);

        userRepository.save(user.get());

        return true;
    }

    public void uploadPicture(User user, MultipartFile file) {
        String filename = uploadFile(file);

        user.setAvatar(filename);
        userRepository.save(user);
    }

    public void uploadCv(Coach coach, MultipartFile file) {
        String filename = uploadFile(file);

        coach.setCv(filename);
    }

    private String uploadFile(MultipartFile file) {
        String filename = file.getOriginalFilename();
        filename =  UUID.randomUUID() + "." + filename.split("\\.")[1];

        try {
            file.transferTo(new File(pictureFolder + filename));
            return filename;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}


