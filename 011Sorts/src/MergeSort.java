
public class MergeSort {


	public static void main(String[] args) {
		int[] list = {17,87,6,22,41,3,13,54};
		for(int i = 0;i<list.length;i++) {
			System.out.print(list[i]+ " ");
		}
		
		list = mergeSort(list, 0, list.length-1);
		System.out.println("");
		for(int i = 0;i<list.length;i++) {
			System.out.print(list[i]+ " ");
		}
		

	}

	private static int[] mergeSort(int[] list, int lowIndex, int highIndex) {
		if(lowIndex == highIndex) {
			return list;
		}
		else {
			int midIndex = (lowIndex + highIndex)/2;
			mergeSort(list, lowIndex, midIndex);
			mergeSort(list, midIndex+1, highIndex);
			merge(list, lowIndex, midIndex+1, highIndex);
		}
		return list;
	}

	private static void merge(int[] list, int lowIndex, int i, int highIndex) {
		// create a temp array
		int temp[] = new int[highIndex - lowIndex + 1];

		// crawlers for both intervals and for temp
		int l = lowIndex, j = i+1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(l <= i && j <= highIndex) {
			if(list[l] <= list[j]) {
				temp[k] = list[l];
				k += 1; l += 1;
			}
			else {
				temp[k] = list[j];
				k += 1; j += 1;
			}
		}

		// add elements left in the first interval 
		while(l <= i) {
			temp[k] = list[l];
			k += 1; l += 1;
		}

		// add elements left in the second interval 
		while(j <= highIndex) {
			temp[k] = list[j];
			k += 1; j += 1;
		}

		// copy temp to original interval
		for(l = lowIndex; l <= highIndex; l += 1) {
			list[l] = temp[l - lowIndex];
		}
		
	}
		
	}

	


