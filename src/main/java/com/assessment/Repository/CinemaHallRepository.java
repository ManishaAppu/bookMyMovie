package com.assessment.Repository;

import com.assessment.Entity.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {

    public static final String FIND_HALL_NAME = "SELECT COUNT(HALL_ID) FROM CINEMA_HALL WHERE HALL_NAME=?";

    @Query(value = FIND_HALL_NAME, nativeQuery = true)
    public int findByHallName(String hallName);

    public static final String FIND_TOTAL_NO_OF_SEATS_BY_SHOW_ID = "select total_seats from movie_show_data msd inner join cinema_hall ch on ch.hall_id = msd.hall_id where msd.movie_show_id = ?";

    @Query(value = FIND_TOTAL_NO_OF_SEATS_BY_SHOW_ID, nativeQuery = true)
    public int findTotalSeatsByShowId(int movieShowId);

}
