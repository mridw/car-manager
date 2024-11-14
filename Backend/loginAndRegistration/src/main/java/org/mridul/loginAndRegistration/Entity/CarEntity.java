package org.mridul.loginAndRegistration.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.mridul.loginAndRegistration.DTO.carDto;

@Entity
@Data
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String tag;
    @Column(columnDefinition = "longblob")
    private byte[] image;
    public carDto getCarDto(){
        carDto cardto = new carDto();
        cardto.setId(id);
        cardto.setTitle(title);
        cardto.setDescription(description);
        cardto.setTag(tag);
        cardto.setReturnedImage(image);
        return cardto;
    };
}
