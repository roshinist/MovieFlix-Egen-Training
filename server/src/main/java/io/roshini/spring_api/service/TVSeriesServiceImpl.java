package io.roshini.spring_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.roshini.spring_api.entity.TVSeries;
import io.roshini.spring_api.exception.BadRequestException;
import io.roshini.spring_api.exception.EntityNotFoundException;
import io.roshini.spring_api.repository.TVSeriesRepository;

@Service
public class TVSeriesServiceImpl implements TVSeriesService{
	
	@Autowired
	private TVSeriesRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> viewAll() {
		// TODO Auto-generated method stub
		return repository.viewAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TVSeries findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TVSeries findByTitle(String title) {
		// TODO Auto-generated method stub
		TVSeries s = repository.findByTitle(title);
		if (s == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return s;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> viewNTop(int n) {
		// TODO Auto-generated method stub
		return repository.viewNTop(n);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> findByYear(int n) {
		// TODO Auto-generated method stub
		return repository.findByYear(n);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return repository.findByGenre(genre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> sortIMDB() {
		// TODO Auto-generated method stub
		return repository.sortIMDB();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> sortYear() {
		// TODO Auto-generated method stub
		return repository.sortYear();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TVSeries> sortVotes() {
		// TODO Auto-generated method stub
		return repository.sortVotes();
	}

	@Override
	@Transactional
	public TVSeries create(TVSeries series) {
		// TODO Auto-generated method stub
		TVSeries existing = repository.findByTitle(series.getTitle());
		if (existing != null) {
			throw new BadRequestException("Series already exists");
		}
		return repository.create(series);
	}

	@Override
	@Transactional
	public TVSeries update(String id, TVSeries series) {
		// TODO Auto-generated method stub
		TVSeries existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Series not found");
		}
		return repository.update(series);
	}

	@Override
	@Transactional
	public TVSeries updateWithTitle(String title, TVSeries series) {
		// TODO Auto-generated method stub
		TVSeries existing = repository.findByTitle(title);
		if (existing == null) {
			throw new EntityNotFoundException("Series not found");
		}
		return repository.update(series);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		TVSeries existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}

}
