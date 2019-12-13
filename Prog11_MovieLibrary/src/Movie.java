/**
 * This class creates object that contains details on a movie. These details are the title, release year, and the rating.
 * 
 * CSC 1350 Programming project No 11
 * Section 2 
 * 
 * @author Martin Dampier
 * @since 12/2/2019
 */

public class Movie {
	private String movieTitle;
	private int releaseYear;
	private String rating;
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
