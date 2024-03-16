package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.UserDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.UserMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserMiniDtoTransformer {

    public UserMiniDto transform(User user){
        Date now = new Date();
        String age = now.getYear() - user.getDate().getYear() + "";

        return UserMiniDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .date(age)
                .password(user.getPassword())
                .avatar(user.getAvatar())
                .approved(user.isApproved())
                .active(user.isActive())
                .build();
    }

    public List<UserMiniDto> transformList(List<User> users){
        List<UserMiniDto> result = new ArrayList<>();
        for(User user : users){
            result.add(transform(user));
        }
        return result;
    }
}
