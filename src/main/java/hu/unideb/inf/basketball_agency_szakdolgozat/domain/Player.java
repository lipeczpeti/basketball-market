package hu.unideb.inf.basketball_agency_szakdolgozat.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Player {
    @Id
    @GeneratedValue
    private int id;
    private int height;
    private int weight;
    private int position;
    private int minSalary;
    private Hand hand;
    private boolean contract;
    @ManyToOne
    private User user;
}
