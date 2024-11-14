package org.mridul.loginAndRegistration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userCredDto {
    private Long id;
    private String email;
    private String password;
    private String name;
}
