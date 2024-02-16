package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDtoTransformer {
    @Autowired
    private UserMiniDtoTransformer userMiniDtoTransformer;


    public PlayerDto transformWithDependencies(Player player){
        return PlayerDto.builder()
                .id(player.getId())
                .height(player.getHeight())
                .weight(player.getWeight())
                .position(player.getPosition())
                .minSalary(player.getMinSalary())
                .hand(player.getHand())
                .contract(player.isContract())
                .user(userMiniDtoTransformer.transform(player.getUser()))
                .build();
    }

    public List<PlayerDto> transformWithDependenciesList(List<Player> players){
        List<PlayerDto> result= new ArrayList<>();
        for(Player player : players){
            result.add(transformWithDependencies(player));
        }
        return result;
    }

}
