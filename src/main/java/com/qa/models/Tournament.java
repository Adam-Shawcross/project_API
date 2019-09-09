package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    Long id;
    String name;
    String location;
    String venue;
    String date;

    public Tournament() {
        super();
    }

    public Tournament(String name, String location, String venue, String date) {
        this.name = name;
        this.location = location;
        this.venue = venue;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTournament(Tournament tournament){
        this.name = tournament.name;
        this.location = tournament.location;
        this.venue = tournament.venue;
        this.date = tournament.date;
    }
}

