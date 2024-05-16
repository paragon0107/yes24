package com.seminar.yes24.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "show")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "subtitle", nullable = false)
    private String subTitle;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "img_url", nullable = false)
    private String img;

    @Column(name = "filmrate", nullable = false)
    private int filmRate;

    @Column(name ="ticket_sales", nullable = false)
    private int ticketSales;
}
