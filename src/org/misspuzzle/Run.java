package org.misspuzzle;

import java.util.ArrayList;
import java.util.List;

import org.misspuzzle.util.ClassUtil;
import org.misspuzzle.puzzle.Puzzle;

public class Run {

	public static void main(String[] args) {

		String[] only = {
			// "Manager"
		};

		String[] excludes = {
			"org.misspuzzle.puzzle.archive"
		};

		List<Class<?>> classes = ClassUtil.getAllClassesByInterface(Puzzle.class, excludes);

		if (only.length > 0) {
			List<Class<?>> onlyClasses = new ArrayList<Class<?>>();

			for (Class<?> cls : classes) {
				for (String onlyName : only) {
					if (cls.getName().contains(onlyName)) {
						onlyClasses.add(cls);
						break;
					}
				}
			}

			classes = onlyClasses;
		}

		for (Class<?> cls : classes) {
			System.out.println("========== Question: " + cls.getSimpleName() + " ==========");

			try {
				Puzzle p = (Puzzle) cls.newInstance();
				p.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println();
		}

	}

}
