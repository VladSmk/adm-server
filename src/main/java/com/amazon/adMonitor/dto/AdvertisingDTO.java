package com.amazon.adMonitor.dto;

import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisingDTO {
    private int id;
    private String title;
    private String description;
    private Date createdAt;
    private String picturePath;
}

