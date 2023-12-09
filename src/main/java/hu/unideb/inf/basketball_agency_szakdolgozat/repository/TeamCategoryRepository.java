package hu.unideb.inf.basketball_agency_szakdolgozat.repository;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.TeamCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamCategoryRepository extends JpaRepository<TeamCategory,Integer> {
}
