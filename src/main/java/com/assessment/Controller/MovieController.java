package com.assessment.Controller;

import com.assessment.Entity.Movie;
import com.assessment.Model.MovieBook;
import com.assessment.Model.MovieModel;
import com.assessment.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    @RequestMapping("/add")
    public String addNewMovie(@RequestBody MovieModel movieModel){
        return "Movie Added Successfully... \n Movie Id " + movieService.addMovie(movieModel);
    }

    @GetMapping
    @RequestMapping("/getMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

}
