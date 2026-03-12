package com.exemple.fastapi_spring.controller;

import com.exemple.fastapi_spring.model.Booking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {
    private List<Booking> bookings = new ArrayList<>();

//    public BookingController() {
//        bookings.add(new Booking("abc", "034","a",1,"a", Instant.now()));
//    }

    @GetMapping("/booking")
    public List<Booking> getBookings() {
        return bookings;
    }

    @PostMapping("/booking")
    public List<Booking> createBooking(@RequestBody List<Booking> booking) {
        bookings.addAll(booking);
        return bookings;
    }
}
