package com.assessment.Model;

import com.assessment.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class MovieReservationModel {

    private int movieReservationId;

    private int movieShowId;

    private int userId;

    private int noOfSeatsReserving;

    private List<Integer> seatNumbers;

}
