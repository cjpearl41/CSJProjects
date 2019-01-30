package s202AP4;
/**
 * 
 * @author Caleb P
 * 
 */
 public class ArrayTester {

	public static void main(String[] args) {
		int[][] arr2D= {
						{0,1,2},
						{3,4,5},
						{6,7,8},
						{9,5,3}
		};
		
		int[] result = ArrayTester.getColumn(arr2D,  1);
		
		for(int i=0; i<result.length;i++) {
			System.out.print(result[i]+", ");
		}
		int[][] square = {
				{1,2,3},
				{2,3,1},
				{3,1,2}
				
				
		};
		/**
		 * Correctly printing true or false earns you the last possible point you can earn for this question
		 */
		boolean tf = ArrayTester.isLatin(square);
		
		System.out.println(tf);

	}
	/**
	 * @return Creating a new array, accessing one column of the arr2D, assigning those values to the new array, and returning the new array gets you four points
	 */
	public static int[] getColumn(int[][] arr2D, int c) {
		
		int[] result = new int[arr2D.length];
		
		for(int r=0; r<arr2D.length;r++) {
			
			result[r]=arr2D[r][c];
		}
		
		return result;
	}
	
	public static boolean isLatin(int[][] square) {
		/** 
		 * <p>containsDuplicates is called earning you one point</p>
		 */
		if(containsDuplicates(square[0])) {
		return false;	
		}
		/**
		 * <p> hasAllValues is called with rows, earning you one point in conjunction with the next time hasAllValues is called getting columns.
		 * Also, this gets you another point as hasAllValues is called for each row and column</p>
		 */
		for(int r=1; r<square.length;r++) {
			if(!hasAllValues(square[0],square[r])) {
				return false;
			}
		}
		/**
		 * getColumns is called getting a valid column, earning you one point
		 */
		for(int c=0; c<square[0].length; c++) {
			if (!hasAllValues(square[0], getColumn(square,c))) {
				return false;
			}
		}
		
		return true;
		
	}
	private static boolean hasAllValues(int[] arr1, int[] arr2) {
		boolean tof = false;
		boolean tof1 = false;
		boolean tof2 = false;
		
		for(int i = 0;i < arr1.length; i++) {
			for (int j = 0; j<arr2.length; j++) {
				if (arr1[i]==arr2[j]) {
					if (i == 0)
						tof = true;
					else if (i ==1)
						tof1 = true;
					else
						tof2 = true;
				}
			}
		}
		if (tof == true && tof1 == true && tof2 == true) {
			return true;
		}
		return false;
	}
	private static boolean containsDuplicates(int[] square) {
		for(int i =1; i<square.length;i++) {
			if(square[i]==square[0]) {
				return true;
			}
		}
		return false;
	}
	
}

