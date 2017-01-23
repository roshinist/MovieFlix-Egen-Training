package io.roshini.spring_api.repository;

import java.util.List;

import io.roshini.spring_api.entity.Movies;

public interface MoviesRepository {

	public List<Movies> viewAllMovies();
	public List<Movies> viewNTopMovies(int n);
	public List<Movies> findByYear(int year);
	public List<Movies> findByGenre(String genre);
	public Movies findByTitle(String title);
	public List<Movies> findByYearAndGenre(int year, String genre);
	public List<Movies> sortIMDB();
	public List<Movies> sortYear();
	public List<Movies> sortVotes();
	public Movies update(Movies m);
	public Movies create(Movies m);
	public void delete(Movies existing);
	public Movies findById(String id);
}
