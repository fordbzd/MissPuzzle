package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimilarMoviesTest {

	@Test
	public void testcase() {
		SimilarMovies.Movie m0 = new SimilarMovies.Movie(0, 0f);
		SimilarMovies.Movie m1 = new SimilarMovies.Movie(1, 6f);
		SimilarMovies.Movie m2 = new SimilarMovies.Movie(2, 2f);
		SimilarMovies.Movie m3 = new SimilarMovies.Movie(3, 3f);
		SimilarMovies.Movie m4 = new SimilarMovies.Movie(4, 4f);

		m0.similarMovies.add(m1);
		m0.similarMovies.add(m2);
		m1.similarMovies.add(m3);
		m2.similarMovies.add(m4);

		List<SimilarMovies.Movie> result = new SimilarMovies().getNearest(m0, 2);

		assertEquals(4, result.get(0).movieId);
		assertEquals(1, result.get(1).movieId);
	}
}
