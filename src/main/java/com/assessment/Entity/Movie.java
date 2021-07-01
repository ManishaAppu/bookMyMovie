package com.assessment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Movie_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    public Movie(String movieName, String movieLanguage, String actor, String actress, String director, String specialCharacters, int isActive) {
        this.movieName = movieName;
        this.movieLanguage = movieLanguage;
        this.actor = actor;
        this.actress = actress;
        this.director = director;
        this.specialCharacters = specialCharacters;
        this.isActive = isActive;
    }

    @Id
    @Column(name= "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(name="movie_name")
    private String movieName;

    @Column(name ="movie_language")
    private String movieLanguage;

    @Column(name ="actor")
    private String actor;

    @Column(name ="actress")
    private String actress;

    @Column(name ="director")
    private String director;

    @Column(name = "special_characters")
    private String specialCharacters;

    @Column(name="is_active")
    private int isActive;

}
