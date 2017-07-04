package puzzles_amazon;

import interfaces.Puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SimilarMovies implements Puzzle {

	@Override
	public void execute() {
		Movie m0 = new Movie(0, 0f);
		Movie m1 = new Movie(1, 6f);
		Movie m2 = new Movie(2, 2f);
		Movie m3 = new Movie(3, 3f);
		Movie m4 = new Movie(4, 4f);

		m0.similarMovies.add(m1);
		m0.similarMovies.add(m2);
		m1.similarMovies.add(m3);
		m2.similarMovies.add(m4);
		
		List<Movie> list = getNearest(m0, 2);
		for (Movie m : list) {
			System.out.println(m.movieId);
		}
	}
	
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

}


class Movie
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
