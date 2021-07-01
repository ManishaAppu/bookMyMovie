package com.assessment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="movie_show_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieShow {

    public MovieShow(int movieId, int hallId, LocalDateTime showDateTime, int isActive) {
        this.movieId = movieId;
        this.hallId = hallId;
        this.showDateTime = showDateTime;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "movie_show_id")
    private int movieShowId;

    @Column(name="movie_id")
    private int movieId;

    @Column(name = "hall_id")
    private int hallId;

    @Column(name="show_date_time")
    private LocalDateTime showDateTime;

    @Column(name="is_active")
    private int isActive;

    @ManyToMany
    @JoinColumn(name = "movie_show_id", referencedColumnName = "movie_show_id")
    private List<MovieReservation> movieReservationList;

    @OneToMany
    @JoinColumn(name="movie_id", referencedColumnName = "movie_id")
    private List<Movie> movieList;

}
