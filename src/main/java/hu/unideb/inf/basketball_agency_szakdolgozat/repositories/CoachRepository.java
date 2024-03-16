package hu.unideb.inf.basketball_agency_szakdolgozat.repositories;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.Coach;
import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Integer> {
    List<Coach> findFirst5ByOrderByIdDesc();

}
