package io.roshini.spring_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.roshini.spring_api.entity.Comments;
import io.roshini.spring_api.entity.Employee;
import io.roshini.spring_api.service.CommentsService;

@RestController
@RequestMapping(value="comments")
public class CommentsController {

	@Autowired
	private CommentsService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Comments> viewAll() {
        return service.viewAll();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "{commentId}")
    public Comments findCommentById(@PathVariable("commentId") String commentId) {
        return service.findCommentById(commentId);
    }
	
    @RequestMapping(method = RequestMethod.GET, value = "movieID={movieId}")
    public List<Comments> findAllCommentsForMovie(@PathVariable("movieId") String movieId) {
        return service.findAllCommentsForMovie(movieId);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Comments create(@RequestBody Comments comment) {
        return service.create(comment);
    }
    
//    @RequestMapping(method = RequestMethod.PUT, value = "{commentId}")
//    public Comments update(@PathVariable("commentId") String commentId, @RequestBody Comments comment) {
//        return service.update(commentId, comment);
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE, value = "{commentId}")
//    public void delete(@PathVariable("commentId") String commentId) {
//        service.delete(commentId);
//    }
    
}
