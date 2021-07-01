package com.assessment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="seat_reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatReservation {

    public SeatReservation(int movieReservationId, int seatNumber) {
        this.movieReservationId = movieReservationId;
        this.seatNumber = seatNumber;
    }

    @Id
    @Column(name="seat_reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatReservationId;

    @Column(name="movie_reservation_id")
    private int movieReservationId;

    @Column(name="seat_number")
    private int seatNumber;


}
