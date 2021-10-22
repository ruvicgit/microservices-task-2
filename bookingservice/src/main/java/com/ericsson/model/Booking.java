package com.ericsson.model;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Booking {
	/**
	 * @param id
	 * @param date
	 * @param time
	 * @param venue
	 * @param numberOfTickets
	 * @param amount
	 * @param fromCurrency
	 * @param sgdAmount
	 * @param sgdCurrency
	 * @param sgdTotalAmount
	 */
	public Booking(int id, String date, String time, String venue, int numberOfTickets, BigDecimal amount,
			String fromCurrency, BigDecimal sgdAmount, String sgdCurrency, BigDecimal sgdTotalAmount) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.numberOfTickets = numberOfTickets;
		this.amount = amount;
		this.fromCurrency = fromCurrency;
		this.sgdAmount = sgdAmount;
		this.sgdCurrency = sgdCurrency;
		this.sgdTotalAmount = sgdTotalAmount;
	}
	@Id
	@GeneratedValue
	private int id;
	
	private String date;
	private String time;
	private String venue;
	private int numberOfTickets;
	private BigDecimal amount;
	private String fromCurrency;
	
	private BigDecimal sgdAmount;
	private String sgdCurrency;
	private BigDecimal sgdTotalAmount;
	
	/**
	 * 
	 */
	public Booking() {
		sgdCurrency = "sgd";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the numberOfTickets
	 */
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	/**
	 * @param numberOfTickets the numberOfTickets to set
	 */
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the fromCurrency
	 */
	public String getFromCurrency() {
		return fromCurrency;
	}
	/**
	 * @param fromCurrency the fromCurrency to set
	 */
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	/**
	 * @return the sgdAmount
	 */
	public BigDecimal getSgdAmount() {
		return sgdAmount;
	}
	/**
	 * @param sgdAmount the sgdAmount to set
	 */
	public void setSgdAmount(BigDecimal sgdAmount) {
		this.sgdAmount = sgdAmount;
	}
	/**
	 * @param id
	 * @param date
	 * @param time
	 * @param numberOfTickets
	 * @param amount
	 * @param fromCurrency
	 * @param toCurrency
	 * @param sgdAmount
	 */
	/**
	 * @param id
	 * @param date
	 * @param time
	 * @param venue
	 * @param numberOfTickets
	 * @param amount
	 * @param fromCurrency
	 * @param toCurrency
	 * @param sgdAmount
	 */

	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}
	/**
	 * @return the sgdTotalAmount
	 */
	public BigDecimal getSgdTotalAmount() {
		return sgdTotalAmount;
	}
	/**
	 * @param sgdTotalAmount the sgdTotalAmount to set
	 */
	public void setSgdTotalAmount(BigDecimal sgdTotalAmount) {
		this.sgdTotalAmount = sgdTotalAmount;
	}
	/**
	 * @return the sgdCurrency
	 */
	public String getSgdCurrency() {
		return sgdCurrency;
	}
	/**
	 * @param sgdCurrency the sgdCurrency to set
	 */
	public void setSgdCurrency(String sgdCurrency) {
		this.sgdCurrency = sgdCurrency;
	}

}
