package com.harsha.personmovie.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870404687095782918L;

	private Integer id;

	private Long imdbId;
	private String title;
	private String storyLine;
	private Date releaseDate;
	private String rated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getImdbId() {
		return imdbId;
	}

	public void setImdbId(Long imdbId) {
		this.imdbId = imdbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStoryLine() {
		return storyLine;
	}

	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

}
