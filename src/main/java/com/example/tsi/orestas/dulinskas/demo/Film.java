package com.example.tsi.orestas.dulinskas.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String title;
    private String description;
    private int release_year;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();

//    @ManyToOne
//    @JoinColumn(name ="review_id", insertable = false, updatable = false)
//    private Review review;

    @OneToMany(mappedBy = "film",
            cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Review> reviews;

    //TEST NEEDED FOR public Film() , and both set<Actor>

    public Film(String title, String description, int release_year){
        this.title = title;
        this.description=description;
        this.release_year=release_year;
    }

    public Set<Actor> getActor(){
        return actor;
    }

    public void setActor(Set<Actor> actor){
        this.actor = actor;
    }

    public Film(){

    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
