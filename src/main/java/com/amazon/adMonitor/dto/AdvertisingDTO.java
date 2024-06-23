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
    private String title;
    private String description;
    private Date createdAt;
    private String picturePath;

    private int impressions;
    private int clicks;
    private int CTR;
    private int conversions;
}

