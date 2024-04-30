package hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;

@Entity
@Getter
@Setter
@ToString
public class Coach {
    @Id
    @GeneratedValue
    private int id;
    private String phoneNumber;
    private String cv;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
