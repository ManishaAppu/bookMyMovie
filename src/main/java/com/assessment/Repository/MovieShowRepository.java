package com.assessment.Repository;

import com.assessment.Entity.Movie;
import com.assessment.Entity.MovieShow;
import com.assessment.Model.MovieShowModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {

    public static final String FIND_SHOW_DETAILS = "select new com.assessment.Model.MovieShowModel(ch.cinemaHallId, ch.hallName, ch.totalNoOfSeats, msd.movieShowId, msd.showDateTime, m.movieId, m.movieName, m.movieLanguage, m.actor, m.actress, m.director, m.specialCharacters) FROM CinemaHall ch inner JOIN MovieShow msd ON ch.cinemaHallId = msd.hallId inner JOIN Movie m ON m.movieId = msd.movieId WHERE ch.cinemaHallId = ?1";

    @Query(value = FIND_SHOW_DETAILS, nativeQuery = false)
    public List<MovieShowModel> findShowDetails(int hallId);

    public int findTotalNoOfSeatsByHallId(int hallId);

}
