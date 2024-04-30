package hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Language> languages;

    private String password;
    private String avatar;
    private boolean approved;
    private boolean active;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Coach> coach;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Player> player;

    private boolean admin;

}
