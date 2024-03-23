package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CoachDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.PlayerDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Player;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CoachDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.PlayerDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerDtoTransformer playerDtoTransformer;

    @Autowired
    private UserRepository userRepository;;

    public List<PlayerDto> getPlayersByNameAndMinAgeAndMaxAge(String name, int ageMin, int ageMax) {

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(now);
        calendar.add(Calendar.YEAR, ageMax * -1);
        Date startDate = calendar.getTime();

        calendar.setTime(now);
        calendar.add(Calendar.YEAR, ageMin * -1);
        Date endDate = calendar.getTime();

        List<Player> players = userRepository.findByNameContainsAndDateAfterAndDateBefore(name, startDate, endDate)
                .stream()
                .filter(user -> !user.getPlayer().isEmpty())
                .map(user -> user.getPlayer().get(0))
                .toList();

        return playerDtoTransformer.transformWithDependenciesList(players);
    }

    public List<PlayerDto> getPlayersByPage(int page, final int pageSize){
        final int finalPage = page-1;

        List<Player> players = playerRepository.findAll();

        return IntStream.range(finalPage*pageSize,(finalPage*pageSize)+pageSize)
                .mapToObj(index-> index < players.size() ? players.get(index) : null)
                .filter(player -> player != null)
                .map(player -> playerDtoTransformer.transformWithDependencies(player))
                .toList();
    }
}
