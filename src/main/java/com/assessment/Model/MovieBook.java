package com.assessment.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieBook {

    private int movieBookedId;

    private int movieReservationId;

    private boolean paymentStatus;

}
