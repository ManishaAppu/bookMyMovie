package com.assessment.Controller;

import com.assessment.Entity.Movie;
import com.assessment.Entity.MovieReservation;
import com.assessment.Entity.MovieShow;
import com.assessment.Model.CinemaHallModel;
import com.assessment.Model.MovieShowModel;
import com.assessment.Service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieShowController {

    @Autowired
    MovieShowService movieShowService;

    @PostMapping("/addCinemaHall")
    public String addCinemaHall(@RequestBody CinemaHallModel cinemaHallModel){
        return " Successfully added the Cinema Hall... \n Cinema Hall Id " +movieShowService.addCinemaHall(cinemaHallModel);
    }

    @PostMapping("/addShow")
    public String addMovieShow(@RequestBody MovieShow movieShow){
        return " Successfully Added the Movie Show \n Show Id " + movieShowService.addMovieShow(movieShow);
    }

   @PostMapping("/getShowDetails/{hallId}")
    public List<MovieShowModel>  getShowDetails(@PathVariable("hallId") int hallId){
       return movieShowService.movieShowDetails(hallId);
   }





}
