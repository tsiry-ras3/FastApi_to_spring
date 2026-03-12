package com.exemple.fastapi_spring.controller;

import com.exemple.fastapi_spring.model.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/booking")
//    public List<Booking> createBooking(@RequestBody List<Booking> newBookings) {
//        bookings.addAll(newBookings);
//        return bookings;
//    }

    @PostMapping("/booking")
    public ResponseEntity<?> updateBooking(@RequestBody List<Booking> newBookings) {
        for (Booking booking : newBookings) {
            if (booking.getNumeroChambre() > 9 || booking.getNumeroChambre() < 1) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Les chambres sont numérotées uniquement de 1 à 9. " +
                        "Veuiller verifier le numero de chambre");
            }
        }
        for (Booking newBooking : newBookings) {
            for (Booking existingBooking : bookings) {
                if (existingBooking.getNumeroChambre() == newBooking.getNumeroChambre()
                        && existingBooking.getDateReservation().equals(newBooking.getDateReservation())) {
                    return ResponseEntity
                            .status(HttpStatus.CONFLICT)
                            .body("Erreur chambre deja occupe");
                }
            }

        }
        bookings.addAll(newBookings);
        return ResponseEntity.ok(bookings);

    }
}
