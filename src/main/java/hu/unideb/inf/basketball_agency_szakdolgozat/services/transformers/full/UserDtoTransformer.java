package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.UserDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.CoachMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.LanguageMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.PlayerMiniDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoTransformer {
    @Autowired
    private PlayerMiniDtoTransformer playerMiniDtoTransformer;
    @Autowired
    private CoachMiniDtoTransformer coachMiniDtoTransformer;
    @Autowired
    private LanguageMiniDtoTransformer languageMiniDtoTransformer;

    public UserDto transformWithDependencies(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .date(user.getDate())
                .languages(languageMiniDtoTransformer.transform(user.getLanguages()))
                .password(user.getPassword())
                .avatar(user.getAvatar())
                .approved(user.isApproved())
                .active(user.isActive())
                .player(playerMiniDtoTransformer.transformList(user.getPlayer()))
                .coach(coachMiniDtoTransformer.transformList(user.getCoach()))
                .build();
    }
}
