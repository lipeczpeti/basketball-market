package hu.unideb.inf.basketball_agency_szakdolgozat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Country {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "country")
    private List<User> users;
}
