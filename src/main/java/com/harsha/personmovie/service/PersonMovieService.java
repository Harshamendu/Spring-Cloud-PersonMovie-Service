package com.harsha.personmovie.service;

import java.util.List;

import com.harsha.personmovie.model.PersonMovie;

public interface PersonMovieService {

	List<PersonMovie> findAllPersonMovie();

	PersonMovie findPersonMoviePersonId(Long personId);

}
