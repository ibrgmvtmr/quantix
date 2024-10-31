package com.quantix.controller;

import com.quantix.entity.Booking;
import com.quantix.service.BookingService;
import com.quantix.service.impl.BookingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable Long userId) {
        return new ResponseEntity<>(bookingService.getBookingsByUser(userId), HttpStatus.OK);
    }
}
