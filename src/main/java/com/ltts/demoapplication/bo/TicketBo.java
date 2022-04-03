package com.ltts.demoapplication.bo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.demoapplication.model.Ticket;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class TicketBo {
	@Autowired
	SessionFactory sf;
	
	public boolean insertTicket(Ticket t) {
		boolean b=false;
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(t);
		s.getTransaction().commit();
		s.close();
		return b;
	}
	
	public List<Ticket> getAllTickets(){
		Session s=sf.openSession();
		s.beginTransaction();
		Query query=s.createQuery("from Ticket");
		List<Ticket> li=query.list();
		s.getTransaction().commit();
		s.close();
		return li;
	}
	
	
	public int getTicketcount(String mname,Date bdate,Time time) {
		Session s=sf.openSession();
		s.beginTransaction();
		String sq="select sum(t.noOfTickets) from Ticket t where t.movie='"+mname+"' and t.showDate='"+bdate+"' and t.showTime='"+time+"'";
		Query query=s.createQuery(sq);
		List<Long> li=query.list();
		System.out.println(li);
		s.getTransaction().commit();
		s.close();
		if(li.get(0)==null)
			return 0;
		return li.get(0).intValue();
	}
	
	public List<Object[]> getHousefullDetails(String mname,LocalDate bdate) {
		Session s=sf.openSession();
		s.beginTransaction();
		String sel="select t.showDate,t.showTime,sum(t.noOfTickets) from Ticket t";
		String whd=" where t.movie='"+mname+"' and t.showDate='"+Date.valueOf(bdate)+"' or t.showDate='"+Date.valueOf(bdate.plusDays(1))+"' or t.showDate='"+Date.valueOf(bdate.plusDays(2))+"' or t.showDate='"+Date.valueOf(bdate.plusDays(3))+"' or t.showDate='"+Date.valueOf(bdate.plusDays(4))+"' or t.showDate='"+Date.valueOf(bdate.plusDays(5))+"'";
		String wht=" and t.showTime='11:00:00' or t.showTime='15:00:00' or t.showTime='18:00:00' or t.showTime='22:00:00'";
	    String grp=" group by t.movie,t.showDate,t.showTime having sum(t.noOfTickets)=500";
	    String ord=" order by t.showDate,t.showTime";
	    Query query=s.createQuery(sel+whd+wht+grp+ord);
	    List<Object[]> li=query.list();
		s.getTransaction().commit();
		s.close();
		return li;
	}

}
