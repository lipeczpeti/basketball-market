package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.UserDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoTransformer {
    @Autowired
    private PlayerDtoTransformer playerDtoTransformer;
    @Autowired
    private CoachDtoTransformer coachDtoTransformer;
    public UserDto transform(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .date(user.getDate())
                .password(user.getPassword())
                .avatar(user.getAvatar())
                .approved(user.isApproved())
                .active(user.isActive())
                .build();
    }

    public UserDto transformWithDependencies(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .date(user.getDate())
                .password(user.getPassword())
                .avatar(user.getAvatar())
                .approved(user.isApproved())
                .active(user.isActive())
                .player(playerDtoTransformer.transformList(user.getPlayer()))
                .coach(coachDtoTransformer.transformList(user.getCoach()))
                .build();
    }
}
