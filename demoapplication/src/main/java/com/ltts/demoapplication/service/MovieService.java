package com.ltts.demoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.demoapplication.bo.MovieBo;
import com.ltts.demoapplication.model.Movie;

@Service
public class MovieService {
	@Autowired
	MovieBo mvb;
	
	public void insertMovie(Movie m) {
		mvb.save(m);
	}
	public List<Movie> findAll(){
		return mvb.findAll();
	}
	public void updateMovie(Movie m) {
		Movie m1 = mvb.getById(m.getMid());
		if(m1.getMid() == m.getMid()) {
			mvb.save(m);
		}
	}
	public Movie getById(int mid) {
		return mvb.getById(mid);
	}
	public void deleteMovie(Movie m) {
		mvb.delete(m);
	}
	public List<String> getLanglist(){
		return mvb.getLangs();
	}
	public List<String> getMovienameslist(){
		return mvb.getMovieNames();
	}
	public List<String> getMovietypelist(){
		return mvb.getMovieTypes();
	}
	public List<Movie> getMoviesByLang(String l){
		return mvb.getMoviesByLang(l);
	}
	public List<Movie> getMoviesByGenre(String g){
		return mvb.getMoviesByGenre(g);
	}
}
