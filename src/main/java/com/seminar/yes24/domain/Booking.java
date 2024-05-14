package com.seminar.yes24.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Table(name="booking")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memeber_runshow_booking_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "runshow_id")
    private RunShow runShow;




    public static Booking create(Member member, RunShow runShow){
        Booking booking = new Booking();
        booking.member = member;
        booking.runShow = runShow;
        return booking;
    }
}
