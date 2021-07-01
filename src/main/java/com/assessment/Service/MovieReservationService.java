package com.assessment.Service;

import com.assessment.Entity.BookTheMovie;
import com.assessment.Entity.MovieReservation;
import com.assessment.Entity.SeatReservation;
import com.assessment.Model.MovieBook;
import com.assessment.Model.MovieReservationModel;
import com.assessment.Repository.BookTheMovieRepository;
import com.assessment.Repository.CinemaHallRepository;
import com.assessment.Repository.MovieReservationRepository;
import com.assessment.Repository.SeatReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieReservationService {

    @Autowired
    MovieReservationRepository movieReservationRepository;

    @Autowired
    CinemaHallRepository cinemaHallRepository;

    @Autowired
    SeatReservationRepository seatReservationRepository;

    @Autowired
    BookTheMovieRepository bookTheMovieRepository;

    public List<Integer> checkMovieAvailability(int movieShowId) {
        List<Integer> seatsReserved = movieReservationRepository.findByMovieShowIdAndIsBookedIsZero(movieShowId, 0);
        int totalAvailableSeats = cinemaHallRepository.findTotalSeatsByShowId(movieShowId);
        List<Integer> availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalAvailableSeats; i++) {
            if (!seatsReserved.contains(i)) {
                availableSeats.add(i);
            }
        }
        System.out.println(" Total No of Seats >>> " + totalAvailableSeats);
        return availableSeats;
    }

    public int saveMovieReservation(MovieReservationModel movieReservationModel) {
        List<Integer> movieReservation = new ArrayList<>();
        int movieReservationId = movieReservationRepository.save(new MovieReservation(movieReservationModel.getMovieShowId(), movieReservationModel.getUserId(), movieReservationModel.getNoOfSeatsReserving(), 0)).getMovieReservationId();
        if (checkMovieAvailability(movieReservationModel.getMovieShowId()).containsAll(movieReservationModel.getSeatNumbers())) {
            for (int seatNumber : movieReservationModel.getSeatNumbers()) {
                movieReservation.add(seatReservationRepository.save(new SeatReservation(movieReservationId, seatNumber)).getSeatReservationId());
            }
            return movieReservationId;
        } else {
            throw new RuntimeException(" Seats already Reserved !!!");
        }
    }

    public int bookTheMovie(MovieBook movieBook){
        if(movieBook.isPaymentStatus()){
            movieReservationRepository.updateIsBookedFlag(movieBook.getMovieReservationId());
            System.out.println(" Movie Reservation Id >>> " + movieBook.getMovieReservationId());
            return bookTheMovieRepository.save(new BookTheMovie(movieBook.getMovieReservationId(), movieBook.isPaymentStatus())).getMovieBookingId();
        }
        else{
            return 0;
        }

    }

    public String cancelMovieReservation(int movieReservationId){

        movieReservationRepository.updateIsBookedFlagCancelReservation(movieReservationId);
        return "Cancelled the Seats Reservation";

    }

}
