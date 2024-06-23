package com.amazon.adMonitor.dto;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdStatisticDTO {
    private String title;
    private double impressions;
    private double clicks;
    private double CTR;
    private double conversions;
}
