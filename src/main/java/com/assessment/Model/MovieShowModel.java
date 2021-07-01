package com.assessment.Model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieShowModel {

    public MovieShowModel(int hall_id, String hall_name, int total_seats, int movie_show_id, LocalDateTime show_date_time, int movie_id, String movie_name, String movie_language, String actor, String actress, String director, String special_characters) {
        this.hall_id = hall_id;
        this.hall_name = hall_name;
        this.total_seats = total_seats;
        this.movie_show_id = movie_show_id;
        this.show_date_time = show_date_time;
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_language = movie_language;
        this.actor = actor;
        this.actress = actress;
        this.director = director;
        this.special_characters = special_characters;
    }

    private int hall_id;

    private String hall_name;

    private int total_seats;

    private int movie_show_id;

    private LocalDateTime show_date_time;

    private int movie_id;

    private String movie_name;

    private String movie_language;

    private String actor;

    private String actress;

    private String director;

    private String special_characters;

    private List<Integer> availableSeats;

}
