package io.roshini.spring_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.roshini.spring_api.entity.Comments;
import io.roshini.spring_api.entity.Movies;
import io.roshini.spring_api.exception.BadRequestException;
import io.roshini.spring_api.exception.EntityNotFoundException;
import io.roshini.spring_api.repository.CommentsRepository;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private CommentsRepository repository;

	@Override
    @Transactional(readOnly = true)
	public List<Comments> viewAll() {
		return repository.viewAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Comments findCommentById(String commentId) {
		Comments existing = repository.findCommentById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comments> findAllCommentsForMovie(String movieId) {
		// TODO Auto-generated method stub
		return repository.findAllCommentsForMovie(movieId);
	}

	@Override
	@Transactional
	public Comments create(Comments comment) {
		// TODO Auto-generated method stub
		Comments existing = repository.findCommentById(comment.getId());
		System.out.println(existing);
		if (existing != null) {
			throw new BadRequestException("Comment already exists");
		}
		comment.setMovies(comment.getMovies());
		//System.out.println("existing is indeed NULL");
		return repository.create(comment);
	}


//	@Override
//	@Transactional
//	public Comments update(String commentId, Comments comment) {
//		// TODO Auto-generated method stub
//		Comments existing = repository.findCommentById(commentId);
//		if (existing != null) {
//			throw new BadRequestException("Comment already exists");
//		}
//		return repository.update(comment);
//	}
//
//	@Override
//	@Transactional
//	public void delete(String commentId) {
//		// TODO Auto-generated method stub
//		Comments existing = repository.findCommentById(commentId);
//		if (existing != null) {
//			throw new BadRequestException("Comment already exists");
//		}
//		repository.delete(existing);
//	}

}
