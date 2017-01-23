package io.roshini.spring_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.roshini.spring_api.entity.TVSeries;
import io.roshini.spring_api.service.TVSeriesService;

@RestController
@RequestMapping(value="tvseries")
public class TVSeriesController {
	
	@Autowired
	private TVSeriesService service;
	
	@RequestMapping(method=RequestMethod.GET, value = "")
	public List<TVSeries> viewAll(){
		return service.viewAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "{id}")
	public TVSeries findById(@PathVariable("id")String id){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "title={title}")
	public TVSeries findByTitle(@PathVariable("title")String title){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.findByTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "topN={topN}")
	public List<TVSeries> viewNTop(@PathVariable("topN") int n){
		return service.viewNTop(n);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "year={year}")
	public List<TVSeries> findByYear(@PathVariable("year")int n){
		return service.findByYear(n);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "genre={genre}")
	public List<TVSeries> findByGenre(@PathVariable("genre")String genre){
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
	public List<TVSeries> sortIMDB(){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.sortIMDB();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "sortYear")
	public List<TVSeries> sortYear(){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.sortYear();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "sortVotes")
	public List<TVSeries> sortVotes(){
		//String encodedTitle = URLEncoder.encode(title, "UTF-8");
		//System.out.println(title);
		return service.sortVotes();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public TVSeries create(@RequestBody TVSeries m) {
		return service.create(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public TVSeries update(@PathVariable("id") String id, @RequestBody TVSeries m) {
		return service.update(id, m);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "title={title}")
	public TVSeries updateWithTitle(@PathVariable("title") String title, @RequestBody TVSeries m) {
		return service.updateWithTitle(title, m);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
}

