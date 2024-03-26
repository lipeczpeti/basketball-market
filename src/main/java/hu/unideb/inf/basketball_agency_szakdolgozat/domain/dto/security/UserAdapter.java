package hu.unideb.inf.basketball_agency_szakdolgozat.domain.dto.security;

import hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAdapter implements UserDetails {

    private User user;
    public UserAdapter (User user){
        this.user = user;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (user.isAdmin()) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
            grantedAuthorities.add(simpleGrantedAuthority);
        }

        if(!user.getPlayer().isEmpty()){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_PLAYER");
            grantedAuthorities.add(simpleGrantedAuthority);
        }

        if (!user.getCoach().isEmpty()){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_COACH");
            grantedAuthorities.add(simpleGrantedAuthority);
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
