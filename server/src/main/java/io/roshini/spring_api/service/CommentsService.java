package io.roshini.spring_api.service;

import java.util.List;

import io.roshini.spring_api.entity.Comments;

public interface CommentsService {

	
	Comments findCommentById(String commentId);

	List<Comments> findAllCommentsForMovie(String movieId);

	Comments create(Comments comment);

	List<Comments> viewAll();

//	Comments update(String commentId, Comments comment);
//
//	void delete(String commentId);

	

}
