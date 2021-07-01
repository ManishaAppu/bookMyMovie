package com.assessment.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@Getter
@Setter
public class CinemaHallModel {

    private String hallName;

    private int totalNoOfSeats;

    private int is_active;
}
