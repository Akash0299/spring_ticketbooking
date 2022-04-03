package com.ltts.demoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.demoapplication.model.Movie;
import com.ltts.demoapplication.service.MovieService;

@RestController
public class ExternalController {
	@Autowired
	MovieService mvs;
	
	@GetMapping("/external/movies")
	public List<Movie> getMovies(){
		return mvs.findAll();
	}
	@GetMapping("/external/movie/{movieid}")
	public Movie getMovie(@PathVariable int movieid) {
		return mvs.getById(movieid);
	}
	@PostMapping("/external/movie")
	public void insertMovie(@RequestBody Movie m) {
		mvs.insertMovie(m);
	}
	@PutMapping("/external/movie")
	public void updateMovie(@RequestBody Movie m) {
		mvs.updateMovie(m);
	}
	@DeleteMapping("/external/movie/{movieid}")
	public void deleteMovie(@PathVariable int movieid) {
		mvs.deleteMovie(mvs.getById(movieid));
	}
}
