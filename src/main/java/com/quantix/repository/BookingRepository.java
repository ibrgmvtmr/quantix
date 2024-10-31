package com.quantix.repository;

import com.quantix.entity.Booking;
import com.quantix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByClient(User user);
}
