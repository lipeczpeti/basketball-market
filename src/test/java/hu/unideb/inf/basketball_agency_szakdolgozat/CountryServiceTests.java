package hu.unideb.inf.basketball_agency_szakdolgozat;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.entity.full.CountryDto;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Country;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.CountryRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.CountryService;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.full.CountryDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.CountryMiniDtoTransformer;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.transformers.mini.UserMiniDtoTransformer;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class CountryServiceTests {

	CountryRepository countryRepository = Mockito.mock(CountryRepository.class);
	UserMiniDtoTransformer userMiniDtoTransformer;
	CountryDtoTransformer countryDtoTransformer;
	CountryService underTest;

	@BeforeEach
	public void setUpMocks() {
		countryRepository = Mockito.mock(CountryRepository.class);
		userMiniDtoTransformer = new UserMiniDtoTransformer();
		countryDtoTransformer = new CountryDtoTransformer(userMiniDtoTransformer);

		underTest = new CountryService(countryRepository, countryDtoTransformer);

	}

	@AfterEach
	public void destroyMocks() throws Exception {
	}

	@Test
	void findAll() {
		Country country1 = new Country();
		country1.setName("Magyarország");
		country1.setUsers(new ArrayList<>());

		Country country2 = new Country();
		country2.setName("Ausztria");
		country2.setUsers(new ArrayList<>());

		List<Country> countries = new ArrayList<>();
		countries.add(country1);
		countries.add(country2);

		Mockito.when(countryRepository.findAll()).thenReturn(countries);

		List<CountryDto> results = underTest.findAll();

		assertEquals(2, results.size());
		assertEquals("Magyarország", results.get(0).getName());
		assertEquals("Ausztria", results.get(1).getName());
	}
}



