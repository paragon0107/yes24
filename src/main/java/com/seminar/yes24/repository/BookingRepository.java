package com.seminar.yes24.repository;

import com.seminar.yes24.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>
{
}
