package com.quantix.service;

import com.quantix.entity.Booking;
import com.quantix.entity.User;

import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);

    List<Booking> getBookingsByUser(Long userId);
}
