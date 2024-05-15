package com.seminar.yes24.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "runshow")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunShow extends Show{

    @Column(name = "period" ,nullable = false)
    private String period;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "run_time", nullable = false)
    private int runTime;

    @Column(name = "likeCount", nullable = false)
    private int likeCount;
}
