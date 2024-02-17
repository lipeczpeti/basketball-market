package hu.unideb.inf.basketball_agency_szakdolgozat.services;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.security.UserAdapter;
import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MySQLUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByName(username);
        if(user == null){
            throw new UsernameNotFoundException("Nincs ilyen felhasználó");
        }

        return new UserAdapter(user);
    }
}
