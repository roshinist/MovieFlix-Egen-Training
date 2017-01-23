package io.roshini.spring_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.roshini.spring_api.entity.Movies;
import io.roshini.spring_api.service.MoviesService;

@RestController
@RequestMapping(value="movies")
public class MoviesController {
	
	@Autowired
	private MoviesService service;
	
	@RequestMapping(method=RequestMethod.GET, value = "")
	public List<Movies> viewAll(){
		return service.viewAllMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "{id}")
	public Movies findById(@PathVariable("id")String id){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "title={title}")
	public Movies findByTitle(@PathVariable("title")String title){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.findByTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "topN={topN}")
	public List<Movies> viewNTop(@PathVariable("topN") int n){
		return service.viewNTopMovies(n);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "year={year}")
	public List<Movies> findByYear(@PathVariable("year")int n){
		return service.findByYear(n);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "genre={genre}")
	public List<Movies> findByGenre(@PathVariable("genre")String genre){
		return service.findByGenre(genre);
	}
	
	
//	@RequestMapping(method=RequestMethod.GET, value="search&year={year}+genre={genre}")
//	public List<Movies> findByfreeText(@PathVariable("year") String year,
//			@PathVariable("genre") String genre){
//
//		//if(year == "" || year == " " && genre == null) return null;
//		if (genre == null && year.length() == 0 || year == null ){
//			//System.out.println(genre);
//			return null;
//		}
//		
//		if(genre != null && year.length() == 1 && year != " "){
//			return service.findByYearAndGenre(Integer.parseInt(year),genre);
//		}
//		else if (year.length() > 1){
//			return service.findByYear(Integer.parseInt(year));
//		}
//		else if (genre != null) {
//			return service.findByGenre(genre);
//		}else{
//			return null;
//		}
//	}
	
	@RequestMapping(method=RequestMethod.GET, value = "sortIMDB")
	public List<Movies> sortIMDB(){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.sortIMDB();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "sortYear")
	public List<Movies> sortYear(){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.sortYear();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "sortVotes")
	public List<Movies> sortVotes(){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.sortVotes();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Movies create(@RequestBody Movies m) {
		return service.create(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Movies update(@PathVariable("id") String id, @RequestBody Movies m) {
		return service.update(id, m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "title={title}")
	public Movies updateWithTitle(@PathVariable("title") String title, @RequestBody Movies m) {
		return service.updateWithTitle(title, m);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String title) {
		service.delete(title);
	}
	
}
