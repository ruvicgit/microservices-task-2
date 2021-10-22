package com.ericsson.model;

import java.math.BigDecimal;

public class SGDCurrency {
	
	private String date;
	private BigDecimal sgd;

	/**
	 * @param date
	 * @param sgd
	 */
	public SGDCurrency(String date, BigDecimal sgd) {
		super();
		this.date = date;
		this.sgd = sgd;
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
	 * @return the sgd
	 */
	public BigDecimal getSgd() {
		return sgd;
	}

	/**
	 * @param sgd the sgd to set
	 */
	public void setSgd(BigDecimal sgd) {
		this.sgd = sgd;
	}

	/**
	 * 
	 */
	public SGDCurrency() {
		super();
		// TODO Auto-generated constructor stub
	}
}
