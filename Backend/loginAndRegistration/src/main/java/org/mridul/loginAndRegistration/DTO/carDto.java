package org.mridul.loginAndRegistration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class carDto {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private MultipartFile image;
    private byte[] returnedImage;
}
