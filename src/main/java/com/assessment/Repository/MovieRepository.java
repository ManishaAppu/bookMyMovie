package com.assessment.Repository;

import com.assessment.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public static final String CHECK_MOVIE_EXIST = "SELECT COUNT(MOVIE_ID) FROM MOVIE_DATA WHERE MOVIE_NAME = ?1 AND MOVIE_LANGUAGE = ?2 AND ACTOR = ?3 AND ACTRESS = ?4 AND DIRECTOR = ?5 AND IS_ACTIVE = 1";

    @Query(value = CHECK_MOVIE_EXIST, nativeQuery = true)
    public int checkMovieExist(String movieName, String movieLanguage, String actor, String actress, String director);

}
