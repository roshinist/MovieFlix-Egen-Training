package io.roshini.spring_api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.roshini.spring_api.entity.Movies;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movies> viewAllMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findAll", Movies.class);
		return query.getResultList();
	}

	@Override
	public List<Movies> viewNTopMovies(int n) {
		// TODO Auto-generated method stub
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findTopN", Movies.class);
		//query.setParameter("pN", n);
		query.setMaxResults(n);
		return query.getResultList();
	}

	@Override
	public List<Movies> findByYear(int year) {
		// TODO Auto-generated method stub
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByYear", Movies.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}
	
	@Override
	public List<Movies> findByGenre(String genre){
		// TODO Auto-generated method stub
		List<Movies> allMovies = this.viewAllMovies();
		List<Movies> moviesInGenre = new ArrayList<Movies>();
		allMovies.forEach((temp) -> {
			String genreStr = temp.getGenre();
			Boolean genreExists = genreStr.toLowerCase().contains(genre.toLowerCase());
			
			if(genreExists){
				moviesInGenre.add(temp);
			}
		});
		return moviesInGenre;
	}
	
	@Override
	public Movies findByTitle(String title){
		//System.out.println(title);
		//return em.find(Movies.class, title);
		//System.out.println(title);
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByTitle", Movies.class);
		query.setParameter("pTitle", title);

		List<Movies> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}

	}
	@Override
	public Movies findById(String id){
		return em.find(Movies.class, id);
	}
	
	@Override
	public List<Movies> findByYearAndGenre(int year, String genre){
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByYear", Movies.class);
		query.setParameter("pYear", year);
		List<Movies> list = query.getResultList();
		List<Movies> intersect = new ArrayList<Movies>();
		
		list.forEach((temp) ->{
			String genreStr = temp.getGenre();
			Boolean genreExists = genreStr.toLowerCase().contains(genre.toLowerCase());
			
			if(genreExists){
				intersect.add(temp);
			}
		});
		return intersect;
	}
	
	@Override
	public List<Movies> sortIMDB(){
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortIMDB", Movies.class);
		return query.getResultList();
	}
	
	public List<Movies> sortYear(){
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortYear", Movies.class);
		return query.getResultList();
	}
	
	public List<Movies> sortVotes(){
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortVotes", Movies.class);
		return query.getResultList();
	}
	
	@Override
	public Movies create(Movies m){
		em.persist(m);
		return m;
	}
	
	@Override
	public Movies update(Movies m) {
		return em.merge(m);
	}
	
	@Override
	public void delete(Movies existing){
		em.remove(existing);
	}
}
