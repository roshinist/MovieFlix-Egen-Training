package io.roshini.spring_api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.roshini.spring_api.entity.Comments;
import io.roshini.spring_api.entity.Movies;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comments> viewAll() {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findAll", Comments.class);
		return query.getResultList();
	}

	@Override
	public List<Comments> findAllCommentsForMovie(String id) {
		Movies mov = em.find(Movies.class, id);
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findAllCommentsForMovie", Comments.class);
	    query.setParameter("pMovies", mov);

	    return query.getResultList();
	}

	@Override
	public Comments findCommentById(String id) {
		return em.find(Comments.class, id);
	}

	@Override
	public Comments create(Comments comment) {
		//em.persist(comment.getMovies());
		em.persist(comment);
		return comment;
		
	}

//	@Override
//	public Comments update(Comments comment) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@Override
//	public void delete(Comments existing) {
//		// TODO Auto-generated method stub
//		
//	}

}
