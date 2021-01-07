package org.misspuzzle.puzzle.amazon;

import java.util.ArrayList;

public class CommonManager {
	
	public Employee commonManager(Employee root, Employee e1, Employee e2) {
		if (root == null) {
			return null;
		}
		
		Result r = new Result();
		
		for (Employee e : root.teams) {
			Employee m = findManager(e, e1, e2, r);
			
			if (r.isFound) {
				return m;
			} else if (m != null) {
				return null;
			}
		}
		
		return null;
		
	}
	
	private Employee findManager(Employee root, Employee e1, Employee e2, Result r) {
		Employee temp1 = null;
		Employee temp2 = null;
		
		for (Employee e : root.teams) {
			Employee m = findManager(e, e1, e2, r);
			
			if (r.isFound) {
				return m;
			} else if (m != null) {
				if (temp1 == null) {
					temp1 = m;
				} else {
					temp2 = m;
				}
			}
			
			if (temp1 != null && temp2 != null) {
				break;
			}
		}
		
		if ((temp1 != null && temp2 != null) ||
				((temp1 != null || temp2 != null) && (root.id == e1.id || root.id == e2.id))) {
			r.isFound = true;
			
			return root;
		}
		
		if (root.id == e1.id || root.id == e2.id) {
			return root;
		}
		
		return temp1 == null ? temp2 : temp1;
		
	}

	static class Employee {
		int id;

		ArrayList<Employee> teams;

		Employee(int name) {
			this.id = name;

			teams = new ArrayList<Employee>();
		}
	}

    class Result {
    	boolean isFound = false;
    }

}
