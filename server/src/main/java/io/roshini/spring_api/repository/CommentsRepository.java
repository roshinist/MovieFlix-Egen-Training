package io.roshini.spring_api.repository;

import java.util.List;

import io.roshini.spring_api.entity.Comments;

public interface CommentsRepository {


	Comments create(Comments comment);

	public List<Comments> findAllCommentsForMovie(String id);

	Comments findCommentById(String id);

	List<Comments> viewAll();

//	Comments update(Comments comment);
//	
//	void delete(Comments existing);

}
