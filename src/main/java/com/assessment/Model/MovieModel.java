package com.assessment.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MovieModel {

    private int movieId;

    private String movieName;

    private int isActive;

    private String movieLanguage;

    private String actor;

    private String actress;

    private String director;

    private String specialCharacters;

}
