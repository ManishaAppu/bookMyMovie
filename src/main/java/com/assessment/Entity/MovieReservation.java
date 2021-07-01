package com.assessment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="movie_reservation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieReservation {

    public MovieReservation(int movieShowId, int userId, int noOfSeatsReserving, int isBooked) {
        this.movieShowId = movieShowId;
        this.userId = userId;
        this.noOfSeatsReserving = noOfSeatsReserving;
        this.isBooked = isBooked;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_reservation_id")
    private int movieReservationId;

    @Column(name = "movie_show_id")
    private int movieShowId;

    @Column(name="user_id")
    private int userId;

    @Column(name="no_of_seats_reserving")
    private int noOfSeatsReserving;

    @Column(name="is_booked")
    private int isBooked;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "movie_reservation_id", referencedColumnName ="movie_reservation_id")
    private BookTheMovie bookTheMovie;

}
