package com.ericsson.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ericsson.model.Booking;
import com.ericsson.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService service = new BookingService();
	
	@GetMapping("Bookings")
	public List<Booking> getBookings()
	{
		return service.getBookings();
	}
	
	@GetMapping("Bookings/{id}")
	public Booking getBookingById(@PathVariable int id)
	{
		return service.getBookingById(id);
	}
	
	@PostMapping("Bookings")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking Booking)
	{
		service.addBooking(Booking);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(Booking.getId())
				.toUri();

		return ResponseEntity.created(uri).body(Booking);
	}
	
	@PutMapping("Bookings")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking Booking)
	{
		service.updateBooking(Booking);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(Booking.getId())
				.toUri();

		return ResponseEntity.created(uri).body(Booking);
	}

	@DeleteMapping("Bookings/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable int id)
	{
		if (service.deleteBookingById(id))
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.badRequest().body("Booking "+id+" couldn't be deleted!");
	}

	
}