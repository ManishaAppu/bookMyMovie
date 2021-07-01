package com.assessment.Controller;

import com.assessment.Entity.MovieReservation;
import com.assessment.Model.MovieBook;
import com.assessment.Model.MovieReservationModel;
import com.assessment.Model.MovieShowModel;
import com.assessment.Service.MovieReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieReservationController {

    @Autowired
    MovieReservationService movieReservationService;

    @PostMapping
    @RequestMapping("/reserveMovie")
    public String reserveMovie(@RequestBody MovieReservationModel movieReservationModel){
        return " Your Movie Reserved .... \n Movie Reservation Id " + movieReservationService.saveMovieReservation(movieReservationModel);
    }

    @GetMapping
    @RequestMapping("/checkSeatAvailability/{movieShowId}")
    public List<Integer> checkSeatAvailability(@PathVariable int movieShowId){
        return movieReservationService.checkMovieAvailability(movieShowId);
    }

    @PostMapping
    @RequestMapping("/bookMovie")
    public String bookMovie(@RequestBody MovieBook movieBook){
         return " Successfully Booked the Movie.. Enjoy... \n Movie Booking Id " +movieReservationService.bookTheMovie(movieBook);
    }

    @PostMapping
    @RequestMapping("/cancelReservation/{movieReservationId}")
    public String cancelReservation(@PathVariable int movieReservationId){
        return movieReservationService.cancelMovieReservation(movieReservationId);
    }

}
