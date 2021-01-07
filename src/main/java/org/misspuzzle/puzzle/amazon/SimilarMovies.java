package org.misspuzzle.puzzle.amazon;

import java.util.*;

public class SimilarMovies {
	
	public List<Movie> getNearest(Movie movie, int numSimilar) {
		 Comparator<Movie> comparator =  new Comparator<Movie>(){  
	            public int compare(Movie m1, Movie m2) {  
	            	return (m1.rating - m2.rating) > 0 ? 1 : -1;
	            }
		 };
		
		Queue<Movie> queue = new PriorityQueue<Movie>(numSimilar, comparator);
		
		findSimilar(movie, queue, new ArrayList<Movie>(), numSimilar);
		
		List<Movie> result = new ArrayList<Movie>();
		Movie m = queue.poll();
		
		while (m != null) {
			result.add(m);
			
			m = queue.poll();
		}
		
		return result;
	}
	
	private void findSimilar(Movie movie, Queue<Movie> queue, List<Movie> visited, int numSimilar) {
		if (visited.contains(movie)) {
			return;
		}
		
		if (queue.size() == numSimilar) {
			queue.poll();
		}
		
		if (visited.size() > 0 && movie != visited.get(0)) {
			queue.add(movie);
		}
		
		visited.add(movie);
		
		for (Movie m : movie.similarMovies) {
			findSimilar(m, queue, visited, numSimilar);
		}
	}

	static class Movie
	{
		int movieId;

		float rating;

		List<Movie> similarMovies;

		Movie(int movieId, float rating) {
			this.movieId = movieId;
			this.rating = rating;

			similarMovies = new ArrayList<Movie>();
		}
	}
}



