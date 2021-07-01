package com.assessment.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movie_booking_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTheMovie {

    public BookTheMovie(int movieReservationId, boolean paymentStatus) {
        this.movieReservationId = movieReservationId;
        this.paymentStatus = paymentStatus;
    }

    @Id
    @Column(name="movie_booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieBookingId;

    @Column(name = "movie_reservation_id")
    private int movieReservationId;

    @Column(name="payment_status")
    private boolean paymentStatus;



}
