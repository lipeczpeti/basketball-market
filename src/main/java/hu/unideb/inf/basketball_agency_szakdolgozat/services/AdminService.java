package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.AdminDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CoachDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.PlayerDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private CoachDtoTransformer coachDtoTransformer;

    @Autowired
    private PlayerDtoTransformer playerDtoTransformer;

    public AdminDto getAdminPageData() {
        List<User> allUsers = userRepository.findByApprovedFalse();

        AdminDto adminDto = new AdminDto();
        adminDto.setCoaches(allUsers.stream()
                .filter(user -> !user.getCoach().isEmpty())
                .map(user -> user.getCoach().get(0))
                .map(coach -> coachDtoTransformer.transformWithDependencies(coach))
                .toList());
        adminDto.setPlayers(allUsers.stream()
                .filter(user -> !user.getPlayer().isEmpty())
                .map(user -> user.getPlayer().get(0))
                .map(player -> playerDtoTransformer.transformWithDependencies(player))
                .toList());

        return adminDto;
    }

    public boolean approveUser(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            user.get().setApproved(true);
            userRepository.save(user.get());

            return true;
        }

        return false;
    }

    public boolean deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return false;
        }

        if (!user.get().getPlayer().isEmpty()) {
            playerRepository.delete(user.get().getPlayer().get(0));
        }

        if (!user.get().getCoach().isEmpty()) {
            coachRepository.delete(user.get().getCoach().get(0));
        }

        userRepository.delete(user.get());

        return true;
    }


}
