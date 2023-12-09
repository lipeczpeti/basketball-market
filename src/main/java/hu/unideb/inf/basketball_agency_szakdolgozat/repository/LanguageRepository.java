package hu.unideb.inf.basketball_agency_szakdolgozat.repository;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
