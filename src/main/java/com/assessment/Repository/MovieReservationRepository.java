package com.assessment.Repository;

import com.assessment.Entity.MovieReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MovieReservationRepository extends CrudRepository<MovieReservation, Integer> {

    public static final String LIST_OF_BOOKED_SEATS_FOR_SHOW_ID = "select sr.seat_number from movie_reservation mr inner join seat_reservation sr on mr.movie_reservation_id = sr.movie_reservation_id where mr.movie_show_id = ?1 and mr.is_booked = ?2";

    @Query(value = LIST_OF_BOOKED_SEATS_FOR_SHOW_ID, nativeQuery = true)
    public List<Integer> findByMovieShowIdAndIsBookedIsZero(int movieShowId, int isBooked);

    public static final String UPDATE_IS_BOOKED_FLAG = "UPDATE MOVIE_RESERVATION SET IS_BOOKED = 1 WHERE MOVIE_RESERVATION_ID = ?";

    @Modifying
    @Query(value = UPDATE_IS_BOOKED_FLAG, nativeQuery = true)
    public void updateIsBookedFlag(int movieReservationId);

    public static final String UPDATE_IS_BOOKED_FLAG_CANCEL_RESERVATION = "UPDATE MOVIE_RESERVATION SET IS_BOOKED = 2 WHERE MOVIE_RESERVATION_ID = ?";

    @Modifying
    @Query(value = UPDATE_IS_BOOKED_FLAG_CANCEL_RESERVATION, nativeQuery = true)
    public void updateIsBookedFlagCancelReservation(int movieReservationId);


}
