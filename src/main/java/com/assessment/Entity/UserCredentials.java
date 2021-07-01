package com.assessment.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_credentials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {

    public UserCredentials(int user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_credentials_id")
    private int user_credentials_id;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;*/

    @Column(name="user_id")
    private int user_id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

}
