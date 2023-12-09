package hu.unideb.inf.basketball_agency_szakdolgozat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class TeamCategory {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
