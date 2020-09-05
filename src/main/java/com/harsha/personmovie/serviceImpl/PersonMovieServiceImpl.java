package com.harsha.personmovie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harsha.personmovie.config.AppConfig;
import com.harsha.personmovie.entity.PersonMovieRel;
import com.harsha.personmovie.model.Movie;
import com.harsha.personmovie.model.PersonMovie;
import com.harsha.personmovie.repo.PersonMovieRepo;
import com.harsha.personmovie.service.PersonMovieService;

@Service
public class PersonMovieServiceImpl implements PersonMovieService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	PersonMovieRepo personMovieRepo;

	@Autowired
	AppConfig appConfig;

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<PersonMovie> findAllPersonMovie() {

		List<PersonMovie> personMovieList = new ArrayList<>();

		String personResponse = restTemplate.getForObject(appConfig.getGetAllPersonsUrl(), String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			personMovieList = mapper.readValue(personResponse.toString(), new TypeReference<List<PersonMovie>>() {
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personMovieList.forEach(persMovie -> {
			List<PersonMovieRel> perMovRel = personMovieRepo.findByPersonId(persMovie.getPersonId());
			List<Movie> movieList = new ArrayList<>();
			perMovRel.forEach(perMovR -> {
				Movie movie = new Movie();
				String movieResponse = restTemplate.getForObject(appConfig.getGetMovieUrl()+perMovR.getImdbId(),
						String.class);
				try {
					movie = mapper.readValue(movieResponse.toString(), Movie.class);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				movieList.add(movie);
			});
			persMovie.setMovieList(movieList);
		});

		return personMovieList;
	}

	@Override
	public PersonMovie findPersonMoviePersonId(Long personId) {
		String personResponse = restTemplate.getForObject(appConfig.getGetPersonUrl() + personId, String.class);

		PersonMovie personMovie = new PersonMovie();
		try {
			personMovie = mapper.readValue(personResponse.toString(), PersonMovie.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		List<PersonMovieRel> perMovRel = personMovieRepo.findByPersonId(personMovie.getPersonId());
		List<Movie> movieList = new ArrayList<>();
		perMovRel.forEach(perMovR -> {
			Movie movie = new Movie();
			String movieResponse = restTemplate.getForObject(appConfig.getGetMovieUrl() + perMovR.getImdbId(),
					String.class);
			try {
				movie = mapper.readValue(movieResponse.toString(), Movie.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			movieList.add(movie);
		});
		personMovie.setMovieList(movieList);
		return personMovie;
	}
}
