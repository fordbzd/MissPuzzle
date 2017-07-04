package puzzles_1;

import interfaces.Puzzle;

public class ReverseInt implements Puzzle {

	@Override
	public void execute() {
		System.out.println(reverse(-2147483648));

	}
	
    public int reverse(int x) {
    	boolean isPositive = true;
    	
    	if (x < 0) {
    		isPositive = false;
    	}
    	
        String n = String.valueOf(x);
        
        if (!isPositive) {
        	n = n.substring(1);
        }
        
        StringBuilder r = new StringBuilder(n).reverse();
        
        char[] maxInt = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        
        if (isPositive) {
        	maxInt[9] = '7';
        }
        
        boolean isOverflow = false;
        if (r.length() == 10) {
        	for (int i = 0; i < maxInt.length; i++) {
        		if (r.charAt(i) > maxInt[i]) {
        			isOverflow = true;
        			break;
        		} else if (r.charAt(i) < maxInt[i]) {
        			break;
        		}
        	}
        	
        	if (isOverflow) {
        		return 0;
        	}
        }
        
        return Integer.parseInt((isPositive ? "" : "-") + r.toString());
    }

}
