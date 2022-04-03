package com.ltts.demoapplication.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ltts.demoapplication.model.Movie;
import com.ltts.demoapplication.model.Show;
import com.ltts.demoapplication.model.Ticket;
import com.ltts.demoapplication.service.MemberService;
import com.ltts.demoapplication.service.MovieService;
import com.ltts.demoapplication.service.TicketService;
import com.ltts.demoapplication.model.Member;

@RestController
@RequestMapping("/movieticket")
public class WelcomeController {
	
	@Autowired
	MemberService ms;
	
	@Autowired
	MovieService mvs;
	
	@Autowired
	TicketService ts;
	
	@RequestMapping("/")
	public ModelAndView m1() {
		return new ModelAndView("index");
	}
	@RequestMapping("/index")
	public ModelAndView mi() {
		return new ModelAndView("index");
	}
	@RequestMapping("/registration")
	public ModelAndView m2() {
		return new ModelAndView("registration");
	}
	@RequestMapping("/login")
	public ModelAndView m3() {
		return new ModelAndView("signup");
	}
	@RequestMapping(value="insert-user", method=RequestMethod.POST)
	public ModelAndView m4(HttpServletRequest request) {
		ModelAndView mv=null;
		String uname=request.getParameter("uname");
		String pswd=request.getParameter("pswd");
		String email=request.getParameter("email");
		int phone=Integer.parseInt(request.getParameter("phone"));
		// ApplicationContext 
		Member m=new Member(uname,pswd,email,phone);
		try {
		ms.insertMember(m);
		mv=new ModelAndView("success");
		}
		catch(Exception e) {
			mv=new ModelAndView("error");
		}
	
		return mv;
	}
	
	@RequestMapping("/userDetail")
	public ModelAndView userInfo(Member reg,HttpServletRequest request) {
		ModelAndView mv = null;
		String name = request.getParameter("uname");
		String pass = request.getParameter("pswd");
		Member m = ms.getMember(name);
		if(m.equals(null)) {
			mv = new ModelAndView("error");
		}else if(m.getUname().equals(name)) {
			if(m.getPswd().equals(pass)){
				mv = new ModelAndView("loginsuccess");
			}else {
				mv = new ModelAndView("error");
			}
			
		}else {
			mv = new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/main")
	public ModelAndView mainPage() {
		return new ModelAndView("main");
	}
	
	@RequestMapping("/addmovie")
	public ModelAndView addm() {
		return new ModelAndView("addmovie");
	}
	
	@RequestMapping(value = "insert-movie",method = RequestMethod.POST)
	public ModelAndView insertingMovie(HttpServletRequest request) {
		ModelAndView mv = null;
		int movieId = 0;
		String imname=request.getParameter("mname");
		String iprod=request.getParameter("production");
		String ihero=request.getParameter("hero");
		String iheroine=request.getParameter("heroine");
		String imtype=request.getParameter("mtype");
		String ilang=request.getParameter("lang");
		String date=request.getParameter("releaseDate");
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		LocalDate releaseDate= LocalDate.parse(date);
		Movie m = new Movie(movieId,imname,iprod,ihero,iheroine,imtype,ilang,releaseDate);
		try {
			mvs.insertMovie(m);
			mv = new ModelAndView("maddsuccess");
		}catch(Exception e) {
			mv = new ModelAndView("error");
		}
		return mv;
	}
	@RequestMapping("/viewmovie")
	public ModelAndView Allmovies(Model m) {
		ModelAndView mv = new ModelAndView("viewAllMovies");
		List<Movie> li = mvs.findAll();
		m.addAttribute("movies",li);
		return mv;
	}
	
	@RequestMapping("/updatemovie")
	public ModelAndView Editmovies(Model m) {
		ModelAndView mv = new ModelAndView("editMovies");
		List<Movie> li = mvs.findAll();
		m.addAttribute("movies",li);
		return mv;
	}
	
	@RequestMapping("/updatemov")
	public ModelAndView updateMovie(@RequestParam String mid,Model m) {
		ModelAndView mv= new ModelAndView("updatemoviedetails");
		Movie mov=mvs.getById(Integer.parseInt(mid));
		m.addAttribute("movie", mov);
		return mv;
	}
	
	@RequestMapping(value = "update-movie",method = RequestMethod.POST)
	public ModelAndView updatingMovie(HttpServletRequest request) {
		ModelAndView mv = null;
		int movieId = Integer.parseInt(request.getParameter("mid"));
		String imname=request.getParameter("mname");
		String iprod=request.getParameter("production");
		String ihero=request.getParameter("hero");
		String iheroine=request.getParameter("heroine");
		String imtype=request.getParameter("mtype");
		String ilang=request.getParameter("lang");
		String date=request.getParameter("releaseDate");
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		LocalDate releaseDate= LocalDate.parse(date);
		Movie m = new Movie(movieId,imname,iprod,ihero,iheroine,imtype,ilang,releaseDate);
		try {
			mvs.insertMovie(m);
			mv = new ModelAndView("mupdatesuccess");
		}catch(Exception e) {
			mv = new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/deletemovie")
	public ModelAndView removemovies(Model m) {
		ModelAndView mv = new ModelAndView("removeMovies");
		List<Movie> li = mvs.findAll();
		m.addAttribute("movies",li);
		return mv;
	}
	
	@RequestMapping("/removemov")
	public ModelAndView deleteMovie(@RequestParam String mid,Model m) {
		ModelAndView mv= new ModelAndView("deletemoviedetails");
		Movie mov=mvs.getById(Integer.parseInt(mid));
		m.addAttribute("dmovie", mov);
		return mv;
	}
	
	@RequestMapping("/delete-movie")
	public ModelAndView deletingMovie(HttpServletRequest request) {
		ModelAndView mv = null;
		int movieId = Integer.parseInt(request.getParameter("mid"));
		Movie m = mvs.getById(movieId);
		try {
			mvs.deleteMovie(m);
			mv = new ModelAndView("mdeletesuccess");
		}catch(Exception e) {
			mv = new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/filtermovie")
    public ModelAndView filterMovie() {
		return new ModelAndView("filtermov");
	}
	
	@RequestMapping("/language")
	public ModelAndView filterbyLang(Model m) {
		ModelAndView mv = null;
		List<String> langs=mvs.getLanglist();
		mv=new ModelAndView("listlanguages");
		m.addAttribute("languages", langs);
		return mv;
	}
	
	@RequestMapping("/genre")
	public ModelAndView filterbyGenre(Model m) {
		ModelAndView mv = null;
		List<String> genres=mvs.getMovietypelist();
		try {
			mv=new ModelAndView("listgenres");
			m.addAttribute("genres", genres);
		} catch (Exception e) {
			mv=new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/lres")
	public ModelAndView getLangMovies(@RequestParam String lang,Model m) {
		ModelAndView mv=null;
		List<Movie> lmovs=mvs.getMoviesByLang(lang);
		try {
			mv=new ModelAndView("viewAllMovies");
			m.addAttribute("movies", lmovs);
		} catch (Exception e) {
			mv=new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/gres")
	public ModelAndView getGenreMovies(@RequestParam String genre,Model m) {
		ModelAndView mv=null;
		List<Movie> gmovs=mvs.getMoviesByGenre(genre);
		try {
			mv=new ModelAndView("viewAllMovies");
			m.addAttribute("movies", gmovs);
		} catch (Exception e) {
			mv=new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/bookticket")
	public ModelAndView ticketbooking(Model m) {
		ModelAndView mv=null;
		List<String> mnames=mvs.getMovienameslist();
		LocalDate cdate=LocalDate.now();
		try {
			mv = new ModelAndView("bookmovieticket");
			m.addAttribute("movlist", mnames);
			m.addAttribute("tdate",cdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv = new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping( value="ticket-moviename",method=RequestMethod.POST)
	public ModelAndView bookingTicket(HttpServletRequest request,Model m) {
		ModelAndView mv=null;
		String mname=request.getParameter("mname");
		LocalDate bdate=LocalDate.now();
		try {
			mv = new ModelAndView("bookmovieshow");
			m.addAttribute("movname", mname);
			m.addAttribute("tdate",bdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv = new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("/showhousefull/{movname}/{tdate}")
	public ModelAndView getHousefull(@PathVariable String movname,@PathVariable String tdate,Model m) {
	  ModelAndView mv=null;
	  DateTimeFormatter dt=DateTimeFormatter.ofPattern("YYYY-MM-dd");
	  LocalDate date=LocalDate.parse(tdate);
	  List<Object[]> dtthf=ts.getHousefull(movname, date);
	  HashMap<LocalDate,ArrayList<LocalTime>> hfshows=new HashMap<>();
	  for(Object[] dtt:dtthf) {
		  LocalDate kdate=LocalDate.parse(dtt[0].toString());
		  if(hfshows.containsKey(kdate)) {
			  hfshows.get(kdate).add(LocalTime.parse(dtt[1].toString()));
		  }
		  else {
			  hfshows.put(kdate, new ArrayList<>());
			  hfshows.get(kdate).add(LocalTime.parse(dtt[1].toString()));
		  }
	  }
	  try {
		mv=new ModelAndView("housefull");
		m.addAttribute("hfshows", hfshows);
	} catch (Exception e) {
		mv=new ModelAndView("error");
	}
	  return mv;
	}
	
	@RequestMapping("/showavailable/{movname}/{tdate}")
	public ModelAndView getAvailable(@PathVariable String movname,@PathVariable String tdate,Model m) {
	  ModelAndView mv=null;
	  DateTimeFormatter dt=DateTimeFormatter.ofPattern("YYYY-MM-dd");
	  LocalDate date=LocalDate.parse(tdate);
	  LocalTime time=LocalTime.now();
	  LocalTime ctime=LocalTime.of(11,0,0);
	  if(time.compareTo(LocalTime.of(22, 0, 0))>=0) {
		  date=date.plusDays(1);
	  }
	  else if(time.compareTo(LocalTime.of(18,0,0))>=0) {
		  ctime=LocalTime.parse("22:00:00");
	  }
	  else if(time.compareTo(LocalTime.of(15,0,0))>=0) {
		  ctime=LocalTime.parse("18:00:00");
	  }
	  else if(time.compareTo(LocalTime.of(11,0,0))>=0) {
		  ctime=LocalTime.parse("15:00:00");
	  }
	  List<LocalTime> times=new ArrayList<>();
	  times.add(LocalTime.of(11, 0, 0));
	  times.add(LocalTime.of(15, 0, 0));
	  times.add(LocalTime.of(18, 0, 0));
	  times.add(LocalTime.of(22, 0, 0));
	  int c=0;
	  List<Show> availshows=new ArrayList<>();
	  List<LocalDate> dates=new ArrayList<>();
	  for(LocalTime temptime:times) {
		  if(temptime.compareTo(ctime)>=0) {
			  int seats=500-(ts.getavailabilty(movname, Date.valueOf(date), Time.valueOf(temptime)));
			  Show s=new Show(date,temptime,(long)seats);
			  if(seats==0) c++;
			  availshows.add(s);
		  }
	  }
	  if(availshows.size()!=c)
		  dates.add(date);
	  for(int i=1;i<=5;i++) {
		  for(LocalTime temptime:times) {
			  int seats=500-(ts.getavailabilty(movname, Date.valueOf(date.plusDays(i)), Time.valueOf(temptime)));
			  Show s=new Show(date.plusDays(i),temptime,(long)seats);
			  if(seats==0) c++;
			  availshows.add(s);
		  }
		  if(c!=4) 
			  dates.add(date.plusDays(i));
	  }
	  try {
		mv=new ModelAndView("available");
		m.addAttribute("movname", movname);
		m.addAttribute("cdate", date);
		m.addAttribute("dates", dates);
	} catch (Exception e) {
		mv=new ModelAndView("error");
	}
	  return mv;
	}
	
	@RequestMapping("/showavailable/{movname}/getmovietime/{movname}/{sdate}")
	public ModelAndView getshowTime(@PathVariable String movname,@PathVariable String sdate,Model m) {
		ModelAndView mv=null;
		LocalDate date=LocalDate.parse(sdate);
		System.out.println(movname+" "+date);
		  List<LocalTime> times=new ArrayList<>();
		  times.add(LocalTime.of(11, 0, 0));
		  times.add(LocalTime.of(15, 0, 0));
		  times.add(LocalTime.of(18, 0, 0));
		  times.add(LocalTime.of(22, 0, 0));
		  List<Show> availshows=new ArrayList<>();
		  for(LocalTime temptime:times) {
				  int seats=500-(ts.getavailabilty(movname, Date.valueOf(date), Time.valueOf(temptime)));
				  if(seats>0) {
					  Show s=new Show(date,temptime,(long)seats);
				      availshows.add(s);
				  }
		  }
		try {
			mv=new ModelAndView("availabletime");
			m.addAttribute("movname",movname);
			m.addAttribute("sdate",date);
			m.addAttribute("availshows",availshows);
		} catch (Exception e) {
			mv=new ModelAndView("error");
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("showavailable/{movname}/getmovietime/{movname}/getticket/{movname}/{sdate}/{stime}/{tcount}")
	public ModelAndView getTicket(@PathVariable String movname,@PathVariable String sdate,@PathVariable String stime,@PathVariable String tcount,Model m) {
		ModelAndView mv=null;
		try {
			mv=new ModelAndView("getmovietickets");
			m.addAttribute("movname", movname);
			m.addAttribute("sdate", LocalDate.parse(sdate));
			m.addAttribute("stime",LocalTime.parse(stime));
			m.addAttribute("tcount",Integer.parseInt(tcount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv=new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("showavailable/{movname}/getmovietime/{movname}/getticket/{movname}/{date}/{time}/bookmovieshow")
	public ModelAndView bookshowTicket(HttpServletRequest request,@PathVariable String movname,@PathVariable String date,@PathVariable String time,@RequestParam String tickets,@RequestParam String ctype,Model m) {
		ModelAndView mv=null;
		try {
			int tno=0;
			int ntickets=Integer.parseInt(tickets);
			Ticket t=new Ticket(tno,movname,ctype,LocalDate.now(),LocalDate.parse(date),LocalTime.parse(time),ntickets);
			ts.addTicket(t);
			int rate=0;
			if(ctype.equals("Economy")) {
				rate=(150*ntickets);
			}
			else if(ctype.equals("Platinum")) {
				rate=(250*ntickets);
			}
			mv=new ModelAndView("booksuccess");
			m.addAttribute("rate",rate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv=new ModelAndView("error");
		}
		return mv;
	}
	
}
