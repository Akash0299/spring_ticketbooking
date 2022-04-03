package com.ltts.demoapplication.bo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ltts.demoapplication.model.Movie;

@Repository
public interface MovieBo extends JpaRepository<Movie,Integer> {
	@Query("SELECT distinct(m.lang) FROM Movie m")
	public List<String> getLangs();
	
	@Query("SELECT distinct(m.mtype) FROM Movie m")
	public List<String> getMovieTypes();
	
	@Query("SELECT distinct(m.mname) FROM Movie m")
	public List<String> getMovieNames();
	
	@Query("SELECT m FROM Movie m where m.lang=?1")
	public List<Movie> getMoviesByLang(String l);
	
	@Query("SELECT m FROM Movie m where m.mtype=?1")
	public List<Movie> getMoviesByGenre(String g);
}
