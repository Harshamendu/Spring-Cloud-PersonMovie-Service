package com.harsha.personmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.personmovie.model.PersonMovie;
import com.harsha.personmovie.service.PersonMovieService;

@RestController
@RequestMapping("/personMovie")
public class PersonMovieController {

	@Autowired
	PersonMovieService personMovieService;
	
	@GetMapping("/getAllPersonMovie")
	public @ResponseBody ResponseEntity<List<PersonMovie>> findPersonMovie() {
		List<PersonMovie> personMovieList = personMovieService.findAllPersonMovie();
		return new ResponseEntity<List<PersonMovie>>(personMovieList, HttpStatus.OK);
	}
	
	@GetMapping("/getPersonMovie")
	public @ResponseBody ResponseEntity<PersonMovie> findPersonMovieByPersonId(@RequestParam String personId) {
		PersonMovie personMovie = personMovieService.findPersonMoviePersonId(Long.valueOf(personId));
		return new ResponseEntity<PersonMovie>(personMovie, HttpStatus.OK);
	}
}
