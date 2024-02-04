package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDtoTransformer {
    @Autowired
    private UserDtoTransformer userDtoTransformer;


    public PlayerDto transform(Player player){
        return PlayerDto.builder()
                .id(player.getId())
                .height(player.getHeight())
                .weight(player.getWeight())
                .position(player.getPosition())
                .minSalary(player.getMinSalary())
                .hand(player.getHand())
                .contract(player.isContract())
                .build();
    }

    public PlayerDto transformWithDependencies(Player player){
        return PlayerDto.builder()
                .id(player.getId())
                .height(player.getHeight())
                .weight(player.getWeight())
                .position(player.getPosition())
                .minSalary(player.getMinSalary())
                .hand(player.getHand())
                .contract(player.isContract())
                .user(userDtoTransformer.transform(player.getUser()))
                .build();
    }

    public List<PlayerDto> transformList(List<Player> players){
        List<PlayerDto> result = new ArrayList<>();

        for(Player player : players){
            result.add(transform(player));
        }
        return result;
    }

}
