package com.assessment.Entity;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cinema_hall")
@Getter
@Setter
public class CinemaHall {


    public CinemaHall(String hallName, int totalNoOfSeats, int is_active) {
        this.hallName = hallName;
        this.totalNoOfSeats = totalNoOfSeats;
        this.is_active = is_active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hall_id")
    private int cinemaHallId;

    @Column(name="hall_name")
    private String hallName;

    @Column(name="total_seats")
    private int totalNoOfSeats;

    @Column(name="is_active")
    private int is_active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_id", referencedColumnName ="hallId")
    private List<MovieShow> movieShow;

}
