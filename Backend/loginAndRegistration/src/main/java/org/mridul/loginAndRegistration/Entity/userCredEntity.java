package org.mridul.loginAndRegistration.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "userCred")
public class userCredEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Id
    private String email;
    private String password;
    private String name;

}
