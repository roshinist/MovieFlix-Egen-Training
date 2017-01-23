package io.roshini.spring_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.roshini.spring_api.entity.Movies;
import io.roshini.spring_api.exception.BadRequestException;
import io.roshini.spring_api.exception.EntityNotFoundException;
import io.roshini.spring_api.repository.MoviesRepository;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movies> viewAllMovies() {
		// TODO Auto-generated method stub
		return repository.viewAllMovies();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movies> viewNTopMovies(int n) {
		// TODO Auto-generated method stub
		return repository.viewNTopMovies(n);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movies> findByYear(int year) {
		// TODO Auto-generated method stub
		return repository.findByYear(year);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movies> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return repository.findByGenre(genre);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Movies findByTitle(String title){
		Movies m = repository.findByTitle(title);
		if (m == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return m;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Movies findById(String id){
		Movies existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return existing;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movies> findByYearAndGenre(int year, String genre){
		return repository.findByYearAndGenre(year, genre);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movies> sortIMDB(){
		return repository.sortIMDB();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movies> sortYear(){
		return repository.sortYear();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movies> sortVotes(){
		return repository.sortVotes();
	}
	
	@Override
	@Transactional
	public Movies create(Movies m){
		Movies existing = repository.findByTitle(m.getTitle());
		if (existing != null) {
			throw new BadRequestException("Movies already exists");
		}
		return repository.create(m);
	}
	
	@Override
	@Transactional
	public Movies updateWithTitle(String title, Movies m){
		Movies existing = repository.findByTitle(title);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(m);
	}
	
	@Override
	@Transactional
	public Movies update(String id, Movies emp) {
		Movies existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(emp);
	}
	
	@Override
	@Transactional
	public void delete(String id){
		Movies existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}

}
