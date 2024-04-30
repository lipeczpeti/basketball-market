package hu.unideb.inf.basketball_agency_szakdolgozat.repositories;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    Optional<User> findByIdAndPassword(int id, String password);
    List<User> findByNameContainsAndDateAfterAndDateBefore(String name, Date min, Date max);

    List<User> findByApprovedFalse();
}
