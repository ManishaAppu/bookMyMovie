package com.assessment.Service;

import com.assessment.Entity.Movie;
import com.assessment.Model.MovieModel;
import com.assessment.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public int addMovie(MovieModel movieModel){
           int movieExist = movieRepository.checkMovieExist(movieModel.getMovieName(), movieModel.getMovieLanguage(), movieModel.getActor(), movieModel.getActress(), movieModel.getDirector());
           if(movieExist != 0){
               throw new RuntimeException("Movie Already Exist");
           }
          return movieRepository.save(new Movie(movieModel.getMovieName(),
                  movieModel.getMovieLanguage(), movieModel.getActor(), movieModel.getActress(),
                  movieModel.getDirector(), movieModel.getSpecialCharacters(), 1)).getMovieId();
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

}
