package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.mini.PlayerMiniDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerMiniDtoTransformer {
    public PlayerMiniDto transform(Player player){
        return PlayerMiniDto.builder()
                .id(player.getId())
                .height(player.getHeight())
                .weight(player.getWeight())
                .position(player.getPosition())
                .minSalary(player.getMinSalary())
                .hand(player.getHand())
                .contract(player.isContract())
                .build();
    }

    public List<PlayerMiniDto> transformList(List<Player> players){
        List<PlayerMiniDto> result = new ArrayList<>();

        for(Player player : players){
            result.add(transform(player));
        }
        return result;
    }
}
