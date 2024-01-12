package hu.unideb.inf.basketball_agency_szakdolgozat.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Team {
   @Id
   @GeneratedValue
   private int id;
   private String name;
   @ManyToMany
   private List<TeamCategory> teamCategories;
}
