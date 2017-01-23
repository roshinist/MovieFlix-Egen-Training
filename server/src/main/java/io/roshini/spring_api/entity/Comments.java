package io.roshini.spring_api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Comments.findAll", query = "SELECT e FROM Comments e"),
	@NamedQuery(name = "Comments.findAllCommentsForMovie", query = "SELECT a FROM Comments a WHERE a.movies = :pMovies") 
})
public class Comments {

	@Id
	private String id;
	
	private String comment;
	
	@ManyToOne
	private Movies movies;
	
//	@ManyToOne
//	private Employee users;
	
	
	//Constructor
	public Comments() {
		this.id = UUID.randomUUID().toString();
	}
	
	//Getters and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	
}
