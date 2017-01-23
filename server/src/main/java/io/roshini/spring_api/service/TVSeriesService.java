package io.roshini.spring_api.service;

import java.util.List;

import io.roshini.spring_api.entity.TVSeries;

public interface TVSeriesService {

	List<TVSeries> viewAll();

	TVSeries findById(String id);

	TVSeries findByTitle(String title);

	List<TVSeries> viewNTop(int n);

	List<TVSeries> findByYear(int n);

	List<TVSeries> findByGenre(String genre);

	List<TVSeries> sortIMDB();

	List<TVSeries> sortYear();

	List<TVSeries> sortVotes();

	TVSeries create(TVSeries m);

	TVSeries update(String id, TVSeries m);

	TVSeries updateWithTitle(String title, TVSeries m);

	void delete(String id);

}
