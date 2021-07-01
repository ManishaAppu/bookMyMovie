package com.assessment.Service;

import com.assessment.Entity.CinemaHall;
import com.assessment.Entity.Movie;
import com.assessment.Entity.MovieShow;
import com.assessment.Model.CinemaHallModel;
import com.assessment.Model.MovieShowModel;
import com.assessment.Repository.CinemaHallRepository;
import com.assessment.Repository.MovieShowRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieShowService {

    @Autowired
    CinemaHallRepository cinemaHallRepository;

    @Autowired
    MovieShowRepository movieShowRepository;

    @Autowired
    MovieReservationService movieReservationService;

    public int addCinemaHall(CinemaHallModel cinemaHallModel){
        int isAlreadyExist = cinemaHallRepository.findByHallName(cinemaHallModel.getHallName());
        if(isAlreadyExist != 0){
            throw new RuntimeException(" Cinema Hall Name Already Registered");
        }

        return cinemaHallRepository.save(new CinemaHall(cinemaHallModel.getHallName(), cinemaHallModel.getTotalNoOfSeats(),cinemaHallModel.getIs_active())).getCinemaHallId();
    }

    public int addMovieShow(MovieShow movieShow){
        return movieShowRepository.save(movieShow).getMovieShowId();
    }

    public List<MovieShowModel>  movieShowDetails(int hallId){
        List<MovieShowModel> movieShowModelList = movieShowRepository.findShowDetails(hallId);
        for(MovieShowModel msm: movieShowModelList){
            msm.setAvailableSeats(movieReservationService.checkMovieAvailability(msm.getMovie_show_id()));
        }
        return movieShowModelList;
    }
}
