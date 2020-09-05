package com.harsha.personmovie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AppConfig {

	@Value( "${personService.person.url}" )
	private String getPersonUrl;

	@Value( "${personService.allperson.url}" )
	private String getAllPersonsUrl;

	@Value( "${movieService.movie.url}" )
	private String getMovieUrl;

	@Value( "${movieService.allmovies.url}" )
	private String getAllMoviesUrl;

	public String getGetPersonUrl() {
		return getPersonUrl;
	}

	public void setGetPersonUrl(String getPersonUrl) {
		this.getPersonUrl = getPersonUrl;
	}

	public String getGetAllPersonsUrl() {
		return getAllPersonsUrl;
	}

	public void setGetAllPersonsUrl(String getAllPersonsUrl) {
		this.getAllPersonsUrl = getAllPersonsUrl;
	}

	public String getGetMovieUrl() {
		return getMovieUrl;
	}

	public void setGetMovieUrl(String getMovieUrl) {
		this.getMovieUrl = getMovieUrl;
	}

	public String getGetAllMoviesUrl() {
		return getAllMoviesUrl;
	}

	public void setGetAllMoviesUrl(String getAllMoviesUrl) {
		this.getAllMoviesUrl = getAllMoviesUrl;
	}
	
	

}
