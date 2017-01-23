package io.roshini.spring_api.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Movies.findAll", query="SELECT e FROM Movies e ORDER BY e.title ASC, e.title ASC"),
	@NamedQuery(name="Movies.findTopN", query="SELECT e FROM Movies e ORDER BY e.imdbRating DESC, e.imdbRating DESC"),
	@NamedQuery(name="Movies.findByYear", query= "SELECT e FROM Movies e WHERE e.year =:pYear ORDER BY e.title ASC, e.title ASC"),
	@NamedQuery(name="Movies.findByTitle", query= "SELECT e FROM Movies e WHERE e.title =:pTitle"),
	@NamedQuery(name="Movies.findByYearAndGenre", query= "SELECT e FROM Movies e WHERE e.year =:pYear AND e.genre=:pGenre"),
	@NamedQuery(name="Movies.sortIMDB", query= "SELECT e FROM Movies e ORDER BY e.imdbRating DESC, e.imdbRating DESC"),
	@NamedQuery(name="Movies.sortYear", query= "SELECT e FROM Movies e ORDER BY e.year DESC, e.year DESC"),
	@NamedQuery(name="Movies.sortVotes", query= "SELECT e FROM Movies e ORDER BY e.imdbVotes DESC, e.imdbVotes DESC")
})
public class Movies {

	@Id
	@Column(columnDefinition="VARCHAR(500)")
	private String id;
	
	@Column(columnDefinition="VARCHAR(500)",unique=true)
	private String title;
	
	@Column(columnDefinition="INT(11)")
	private int year;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String rated;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String released;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String runtime;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String genre;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String director;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String writer;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String actors;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String plot;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String language;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String country;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String awards;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String poster;
	
	@Column(columnDefinition="INT(11)")
	private int metaScore;
	
	@Column(columnDefinition="DECIMAL(2,1)")
	private float imdbRating;
	
	@Column(columnDefinition="INT(11)")
	private int imdbVotes;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String imdbId;
	
	@Column(columnDefinition="VARCHAR(500)")
	private String type;
	
//	@OneToMany
//	private List<Comments> comments;
	
	//Constructors
	//Unique UUID
	//Constructor
	public Movies(){
		this.id = UUID.randomUUID().toString();
	}
	
	//Getters and Setters
	public String getMovieID() {
		return id;
	}
	public void setMovieID(String movieID) {
		this.id = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "Movies [movieID=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + "]";
	}
}
