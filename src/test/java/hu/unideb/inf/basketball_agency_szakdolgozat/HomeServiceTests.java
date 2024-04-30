package hu.unideb.inf.basketball_agency_szakdolgozat;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.page.HomeDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.*;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CoachRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CountryRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.PlayerRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.TeamRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.CountryService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.HomeService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.*;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.TeamCategoryMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.TeamMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class HomeServiceTests {

	private CoachRepository coachRepository;
	private PlayerRepository playerRepository;
	private TeamRepository teamRepository;
	private HomeDtoTransformer homeDtoTransformer;
	private PlayerDtoTransformer playerDtoTransformer;
	private CoachDtoTransformer coachDtoTransformer;
	private TeamDtoTransformer teamDtoTransformer;
	private UserMiniDtoTransformer userMiniDtoTransformer;
	private TeamMiniDtoTransformer teamMiniDtoTransformer;
	private TeamCategoryMiniDtoTransformer teamCategoryMiniDtoTransformer;

	private HomeService underTest;

	@BeforeEach
	public void setUpMocks() {
		coachRepository = Mockito.mock(CoachRepository.class);
		playerRepository = Mockito.mock(PlayerRepository.class);
		teamRepository = Mockito.mock(TeamRepository.class);

		teamCategoryMiniDtoTransformer = new TeamCategoryMiniDtoTransformer();
		teamMiniDtoTransformer = new TeamMiniDtoTransformer();
		userMiniDtoTransformer = new UserMiniDtoTransformer();

		teamDtoTransformer = new TeamDtoTransformer(teamCategoryMiniDtoTransformer);
		coachDtoTransformer = new CoachDtoTransformer(userMiniDtoTransformer);
		playerDtoTransformer = new PlayerDtoTransformer(userMiniDtoTransformer, teamMiniDtoTransformer);
		homeDtoTransformer = new HomeDtoTransformer(playerDtoTransformer,coachDtoTransformer,teamDtoTransformer);

		underTest = new HomeService(coachRepository, playerRepository, teamRepository, homeDtoTransformer);

	}

	@Test
	void getHome() {
		// given
		List<Player> players = new ArrayList<>();
		List<Coach> coaches = new ArrayList<>();
		List<Team> teams = new ArrayList<>();

		User user = new User();
		user.setCountry(new Country());
		user.setActive(true);
		user.setApproved(true);
		user.setAdmin(true);
		user.setDate(new Date());
		user.setEmail("asb@gmail.com");
		user.setPassword("1234");
		user.setName("Sanyika");
		user.setId(666);
		user.setLanguages(new ArrayList<>());
		user.setAvatar("klafdsj");
		user.setPlayer(new ArrayList<>());
		user.setCoach(new ArrayList<>());

		Player player = new Player();
		player.setTeam(new Team());
		player.setContract(true);
		player.setUser(new User());
		player.setHand(Hand.LEFT);
		player.setHeight(192);
		player.setWeight(100);
		player.setPosition(1);
		player.setMinSalary(100);
		player.setUser(user);

		Player player2 = new Player();
		player2.setTeam(new Team());
		player2.setContract(false);
		player2.setUser(new User());
		player2.setHand(Hand.RIGHT);
		player2.setHeight(198);
		player2.setWeight(105);
		player2.setPosition(3);
		player2.setMinSalary(200);
		player2.setUser(user);
		players.add(player);
		players.add(player2);


		Coach coach = new Coach();
		coach.setUser(user);
		coach.setPhoneNumber("+3630");
		coach.setCv("cv");
		coaches.add(coach);

		Team team = new Team();
		team.setName("Blue Sharks");
		team.setTeamCategories(new ArrayList<>());
		team.setPlayers(players);
		teams.add(team);

		when(coachRepository.count()).thenReturn(1l);
		when(playerRepository.count()).thenReturn(2l);
		when(teamRepository.count()).thenReturn(3l);

		when(playerRepository.findFirst5ByOrderByIdDesc()).thenReturn(players);
		when(coachRepository.findFirst5ByOrderByIdDesc()).thenReturn(coaches);
		when(teamRepository.findFirst5ByOrderByIdDesc()).thenReturn(teams);

		// when
		HomeDto result = underTest.getHome();

		// then
		assertEquals(1l, result.getCoach());
		assertEquals(2l, result.getPlayer());
		assertEquals(3l, result.getClub());

		assertEquals(2, result.getPlayers().size());
		assertEquals(true, result.getPlayers().get(0).isContract());
		assertEquals(Hand.LEFT, result.getPlayers().get(0).getHand());
		assertEquals(192, result.getPlayers().get(0).getHeight());
		assertEquals(100, result.getPlayers().get(0).getWeight());
		assertEquals(1, result.getPlayers().get(0).getPosition());
		assertEquals(100, result.getPlayers().get(0).getMinSalary());

		assertEquals(1, result.getCoaches().size());
		assertEquals("+3630", result.getCoaches().get(0).getPhoneNumber());
		assertEquals("cv", result.getCoaches().get(0).getCv());

		assertEquals(1, result.getTeams().size());
		assertEquals("Blue Sharks", result.getTeams().get(0).getName());


	}
}



