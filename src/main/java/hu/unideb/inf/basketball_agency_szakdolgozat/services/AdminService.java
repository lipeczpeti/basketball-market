package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.AdminDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CoachDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.PlayerDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

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

}
