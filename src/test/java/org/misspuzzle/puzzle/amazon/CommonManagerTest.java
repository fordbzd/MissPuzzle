package org.misspuzzle.puzzle.amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonManagerTest {

	@Test
	public void testcase() {
		CommonManager.Employee root = new CommonManager.Employee(0);

		root.teams.add(new CommonManager.Employee(1));
		root.teams.add(new CommonManager.Employee(2));
		root.teams.add(new CommonManager.Employee(3));

		root.teams.get(0).teams.add(new CommonManager.Employee(4));
		root.teams.get(0).teams.add(new CommonManager.Employee(5));

		root.teams.get(0).teams.get(1).teams.add(new CommonManager.Employee(6));

		root.teams.get(2).teams.add(new CommonManager.Employee(7));
		root.teams.get(2).teams.add(new CommonManager.Employee(8));

		// Test
		CommonManager.Employee m = new CommonManager().commonManager(root, new CommonManager.Employee(5), new CommonManager.Employee(4));

		assertEquals(1, m.id);
	}
}
