package hu.unideb.inf.basketball_agency_szakdolgozat.services.security;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.security.UserAdapter;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class MySQLUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Nincs ilyen felhasználó");
        }

        return new UserAdapter(user);
    }
}
