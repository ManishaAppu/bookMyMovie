package com.assessment.Entity;

import lombok.*;

import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="user_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    public User(String firstName, String lastName, String location, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 //   @OneToMany(mappedBy = "user_account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int usedId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String location;

    @Column(name ="phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName ="user_id")
    private UserCredentials userCredentials;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private List<MovieReservation> movieReservation;

}
