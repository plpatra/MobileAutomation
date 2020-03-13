package com.org.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.movie.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {


	@Autowired
	private MovieService movieService;

	@GetMapping("/search")
	public HttpEntity<?> searchMovieDetails(@RequestParam("query") String query) {

		return movieService.searchMovieDetails(query);
	}

}
