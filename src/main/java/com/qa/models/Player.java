package com.qa.models;


import javax.persistence.*;

@Entity
@Table(name="Players")
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private Long age;
    private Float earnings;
    private Long ranking;


    public Player() {
        super();
    }
    public Player(String lastName, String firstName, Long age, Float earnings, Long ranking) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.earnings = earnings;
        this.ranking = ranking;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
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
        this.lastName = player.lastName;
        this.firstName = player.firstName;
        this.age = player.age;
        this.earnings = player.earnings;
        this.ranking = player.ranking;
    }
}

