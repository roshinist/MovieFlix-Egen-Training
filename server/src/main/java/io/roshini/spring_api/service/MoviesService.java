package io.roshini.spring_api.service;

import java.util.List;


import io.roshini.spring_api.entity.Movies;

public interface MoviesService {

	public List<Movies> viewAllMovies();
	public List<Movies> viewNTopMovies(int n);
	public List<Movies> findByYear(int year);
	public List<Movies> findByGenre(String genre);
	public Movies findByTitle(String title);
	public List<Movies> findByYearAndGenre(int year, String genre);
	public List<Movies> sortIMDB();
	public List<Movies> sortYear();
	public List<Movies> sortVotes();
	public Movies create(Movies m);
	public Movies updateWithTitle(String title, Movies m);
	public Movies update(String id, Movies m);
	public void delete(String title);
	public Movies findById(String id);
	
}
