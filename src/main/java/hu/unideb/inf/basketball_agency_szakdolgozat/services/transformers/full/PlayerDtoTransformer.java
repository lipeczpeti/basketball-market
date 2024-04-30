package hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.TeamCategoryMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.TeamMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PlayerDtoTransformer {

    private UserMiniDtoTransformer userMiniDtoTransformer;
    private TeamMiniDtoTransformer teamMiniDtoTransformer;


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
                .team(teamMiniDtoTransformer.transform(player.getTeam()))
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
