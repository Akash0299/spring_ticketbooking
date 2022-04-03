package com.ltts.demoapplication.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketNo;
	private String movie;
	private String circleType;
	private LocalDate bookingDate;
	private LocalDate showDate;
	private LocalTime showTime;
	private int noOfTickets;
	public Ticket() {
		super();
	}
	public Ticket(int ticketNo, String movie, String circleType, LocalDate bookingDate, LocalDate showDate,
			LocalTime showTime, int noOfTickets) {
		super();
		this.ticketNo = ticketNo;
		this.movie = movie;
		this.circleType = circleType;
		this.bookingDate = bookingDate;
		this.showDate = showDate;
		this.showTime = showTime;
		this.noOfTickets = noOfTickets;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getCircleType() {
		return circleType;
	}
	public void setCircleType(String circleType) {
		this.circleType = circleType;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	@Override
	public String toString() {
		return "Ticket ticketNo=" + ticketNo + ", movie=" + movie + ", circleType=" + circleType + ", noOfTickets="
				+ noOfTickets;
	}
	
	
}
