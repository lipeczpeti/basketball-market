package hu.unideb.inf.basketball_agency_szakdolgozat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;

@Entity
@Getter
@Setter
@ToString
public class Agent{
    @Id
    @GeneratedValue
    private int id;
    private String phoneNumber;
    private boolean privateAgent;
    private File cv;
    @ManyToOne
    private User user;
}
