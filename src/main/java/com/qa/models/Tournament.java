package com.qa.models;

import javax.persistence.*;


@Entity
@Table(name = "Tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String location;
    private String venue;


    public Tournament() {
        super();
    }

    public Tournament(String name, String location, String venue) {
        this.name = name;
        this.location = location;
        this.venue = venue;

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


    public void setTournament(Tournament tournament) {
        this.name = tournament.name;
        this.location = tournament.location;
        this.venue = tournament.venue;

    }
}

