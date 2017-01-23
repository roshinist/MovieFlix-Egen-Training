package io.roshini.spring_api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.roshini.spring_api.entity.TVSeries;

@Repository
public class TVSeriesRepositoryImpl implements TVSeriesRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<TVSeries> viewAll() {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.findAll", TVSeries.class);
		return query.getResultList();
	}

	@Override
	public TVSeries findById(String id) {
		// TODO Auto-generated method stub
		return em.find(TVSeries.class, id);
	}

	@Override
	public TVSeries findByTitle(String title) {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.findByTitle", TVSeries.class);
		query.setParameter("pTitle", title);

		List<TVSeries> series = query.getResultList();
		if (series != null && series.size() == 1) {
			return series.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<TVSeries> viewNTop(int n) {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.findTopN", TVSeries.class);
		//query.setParameter("pN", n);
		query.setMaxResults(n);
		return query.getResultList();
	}

	@Override
	public List<TVSeries> findByYear(int n) {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.findByYear", TVSeries.class);
		query.setParameter("pYear", n);
		return query.getResultList();
	}

	@Override
	public List<TVSeries> findByGenre(String genre) {
		// TODO Auto-generated method stub
		List<TVSeries> allSeries = this.viewAll();
		List<TVSeries> seriesInGenre = new ArrayList<TVSeries>();
		allSeries.forEach((temp) -> {
			String genreStr = temp.getGenre();
			Boolean genreExists = genreStr.toLowerCase().contains(genre.toLowerCase());
			
			if(genreExists){
				seriesInGenre.add(temp);
			}
		});
		return seriesInGenre;
	}

	@Override
	public List<TVSeries> sortIMDB() {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.sortIMDB", TVSeries.class);
		return query.getResultList();
	}

	@Override
	public List<TVSeries> sortVotes() {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.sortVotes", TVSeries.class);
		return query.getResultList();
	}

	@Override
	public List<TVSeries> sortYear() {
		// TODO Auto-generated method stub
		TypedQuery<TVSeries> query = em.createNamedQuery("TVSeries.sortYear", TVSeries.class);
		return query.getResultList();
	}

	@Override
	public TVSeries create(TVSeries series) {
		// TODO Auto-generated method stub
		em.persist(series);
		return series;
	}

	@Override
	public TVSeries update(TVSeries series) {
		// TODO Auto-generated method stub
		return em.merge(series);
	}

	@Override
	public void delete(TVSeries existing) {
		// TODO Auto-generated method stub
		em.remove(existing);
	}

}
