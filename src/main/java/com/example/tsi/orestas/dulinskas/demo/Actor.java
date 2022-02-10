package com.example.tsi.orestas.dulinskas.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int actor_id;
        private String first_name;
        private String last_name;

//    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Film> films = new HashSet<>();

    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    // TEST NEEDED FOR public Actor()

    public Actor(){
    }

        public int getActor_id() {
            return actor_id;
        }

        public void setActor_id(int actor_id) {
            this.actor_id = actor_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        // TEST NEEDED FOR ALL BELLOW

//    public Set<Film> getFilms(){
//        return films;
//    }
//
//    public void setFilms(Set<Film> films){
//        this.films = films;
//    }

    }

