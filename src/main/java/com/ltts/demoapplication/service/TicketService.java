package com.ltts.demoapplication.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.demoapplication.bo.TicketBo;
import com.ltts.demoapplication.model.Ticket;

@Service
public class TicketService {
	@Autowired
	TicketBo tb;
	
	public boolean addTicket(Ticket t) {
		return tb.insertTicket(t);
	}
	
	public int getavailabilty(String mname,Date bdate,Time time) {
		return tb.getTicketcount(mname,bdate,time);
	}
	
	public List<Object[]> getHousefull(String mname,LocalDate bdate) {
		return tb.getHousefullDetails(mname, bdate);
	}
	
}
