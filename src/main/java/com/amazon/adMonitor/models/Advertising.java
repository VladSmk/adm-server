package com.amazon.adMonitor.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advertising")
public class Advertising {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "picture_path")
    private String picturePath;

    @Column(name = "impressions")
    private int impressions;
    @Column(name = "clicks")
    private int clicks;
    @Column(name = "CTR")
    private int CTR;
    @Column(name = "conversions")
    private int conversions;
}
