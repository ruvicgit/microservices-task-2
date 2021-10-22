package com.ericsson.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ericsson.model.*;
import com.ericsson.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	private Environment env;
	private String currencyURL;
	private final String SGD_CURRENCY = "sgd";
	
	/**
	 * @return the todos
	 */
	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(int id)
	{
		return bookingRepository.findById(id).orElseThrow(null);
	}
	
	public Booking addBooking(Booking booking)
	{
		BigDecimal sgdAmount = convertCurrency(booking.getFromCurrency(), SGD_CURRENCY
				, booking.getAmount(), booking.getNumberOfTickets());
		
		booking.setSgdAmount(sgdAmount);
		
		return bookingRepository.save(booking);
	}
	
	public boolean updateBooking(Booking booking)
	{
		bookingRepository.findById(booking.getId()).orElseThrow(null);
		
		BigDecimal sgdAmount = convertCurrency(booking.getFromCurrency(), SGD_CURRENCY
												, booking.getAmount(), booking.getNumberOfTickets());
		booking.setSgdAmount(sgdAmount);
		
		bookingRepository.save(booking);
		return true;
	}		
	
	public boolean deleteBookingById(int id)
	{
		bookingRepository.deleteById(id);
		return true;
	}	
	
	public BigDecimal convertCurrency(String fromCurr, String toCurr, BigDecimal amount, int noOfTickets) {
		
		//check if input amount equal to zero then return zero
		if (amount.compareTo(new BigDecimal("0.00")) == 0) {
			return BigDecimal.ZERO;
		}		
		
		//else currency convert call service
		currencyURL = env.getProperty("currency.url");
		
		//replace from currency position
		currencyURL = currencyURL.replace("<<Source Currency>>", fromCurr);
		
		//replace to currency position
		currencyURL = currencyURL.replace("<<Target Currency>>", toCurr);
		System.out.println("currency url : " + currencyURL);
		
		//call currency service
		RestTemplate restTemplate = new RestTemplate();
		SGDCurrency currencyResponse = restTemplate.getForObject(currencyURL, SGDCurrency.class);
		
		System.out.println("currency conversion :" + currencyResponse.getSgd());

		return (currencyResponse.getSgd().multiply(amount.multiply(BigDecimal.valueOf(noOfTickets))));
	}
}
