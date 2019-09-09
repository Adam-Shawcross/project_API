package com.qa.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String lastName;
    String firstName;
    String DOB;
    Float earnings;
    Long ranking;


    public Player() {
        super();
    }
    public Player(String lastName, String firstName, String DOB, Float earnings, Long ranking) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.DOB = DOB;
        this.earnings = earnings;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Float getEarnings() {
        return earnings;
    }

    public void setEarnings(Float earnings) {
        this.earnings = earnings;
    }

    public Long getRanking() {
        return ranking;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }


    public void setPlayer(Player player){
        this.lastName = lastName;
        this.firstName = firstName;
        this.DOB = DOB;
        this.earnings = earnings;
        this.ranking = ranking;
    }
}

