package hu.unideb.inf.basketball_agency_szakdolgozat.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String email;

    @ManyToOne
    private Country country;

    private Date date;

    @ManyToMany
    private List<Language> languages;

    private String password;
    private File avatar;
    private boolean approved;
    private boolean active;

    @OneToMany(mappedBy = "user")
    private List<Agent> agents;

    @OneToMany(mappedBy = "user")
    private List<Player> players;

}
