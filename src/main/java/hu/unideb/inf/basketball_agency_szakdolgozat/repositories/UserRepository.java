package hu.unideb.inf.basketball_agency_szakdolgozat.repositories;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
