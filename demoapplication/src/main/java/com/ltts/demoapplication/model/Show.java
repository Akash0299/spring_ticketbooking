package com.ltts.demoapplication.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {
	LocalDate sdate;
	LocalTime stime;
	Long ticketcount;
	public Show() {
		super();
	}
	public Show(LocalDate sdate, LocalTime stime, Long ticketcount) {
		super();
		this.sdate = sdate;
		this.stime = stime;
		this.ticketcount = ticketcount;
	}
	public LocalDate getSdate() {
		return sdate;
	}
	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}
	public LocalTime getStime() {
		return stime;
	}
	public void setStime(LocalTime stime) {
		this.stime = stime;
	}
	public Long getTicketcount() {
		return ticketcount;
	}
	public void setTicketcount(Long ticketcount) {
		this.ticketcount = ticketcount;
	}
	@Override
	public String toString() {
		return "Show [sdate=" + sdate + ", stime=" + stime + ", ticketcount=" + ticketcount + "]";
	}
	
}
