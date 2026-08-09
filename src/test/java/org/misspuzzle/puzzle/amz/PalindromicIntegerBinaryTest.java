package org.misspuzzle.puzzle.amz;

import org.junit.jupiter.api.Test;
// import unnecessary in same package
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PalindromicIntegerBinaryTest {

	@Test
	public void testcase() {
		final boolean result = new PalindromicIntegerBinary().isPalindromic(10);

		assertFalse(result);
	}
}
