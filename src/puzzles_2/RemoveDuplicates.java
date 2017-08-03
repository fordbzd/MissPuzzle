package puzzles_2;

import interfaces.Puzzle;

public class RemoveDuplicates implements Puzzle {

	@Override
	public void execute() {
		int[] nums = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4};
		
		System.out.println("Length: " + removeDuplicates(nums));
		
		for (int n : nums) {
			System.out.println(n);
		}
	}
	
    public int removeDuplicates(int[] nums) {
		int n = nums.length;

		if (n < 2)
			return n;
		
		int id = 1;
		
		for (int i = 1; i < n; ++i)
			if (nums[i] != nums[i - 1])
				nums[id++] = nums[i];
		return id;
    }

}
