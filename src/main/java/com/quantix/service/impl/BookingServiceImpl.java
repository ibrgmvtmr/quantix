package com.quantix.service.impl;

import com.quantix.controller.UserRepository;
import com.quantix.entity.Booking;
import com.quantix.entity.User;
import com.quantix.repository.BookingRepository;
import com.quantix.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        User user = userRepository.findById(userId).get();
        return bookingRepository.findByClient(user);
    }
}
