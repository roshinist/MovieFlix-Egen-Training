package io.roshini.spring_api.repository;

import java.util.List;

import io.roshini.spring_api.entity.TVSeries;

public interface TVSeriesRepository {

	List<TVSeries> viewAll();

	TVSeries findById(String id);

	TVSeries findByTitle(String title);

	List<TVSeries> viewNTop(int n);

	List<TVSeries> findByYear(int n);

	List<TVSeries> findByGenre(String genre);

	List<TVSeries> sortIMDB();

	List<TVSeries> sortVotes();
	
	List<TVSeries> sortYear();

	TVSeries create(TVSeries series);

	TVSeries update(TVSeries series);

	void delete(TVSeries existing);

	

}
