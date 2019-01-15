import java.util.Arrays;
import java.util.Random;
public class QuickSort {

	

	public QuickSort(int[] intList, char[] alphaList) {
		quickSort(intList,alphaList, 0, intList.length-1);
		System.out.println("This is the beginning of the Quick Sort");
		for(int i =0; i<intList.length;i++) {
			if (intList[i]>0) {
				System.out.println(alphaList[i]+": "+intList[i]);
			}
	}
	}
	
	private void quickSort(int[] A, char[]B, int low, int high) {
		if(low<high+1) {
			int p = partition(A,B, low, high);
			quickSort(A,B, low, p-1);
			quickSort(A,B, p+1, high);
				
		}
	}
	private void swap(int[] A, char[] B, int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
		
		char temp2 = B[index1];
		B[index1] = B[index2];
		B[index2] = temp2;
	}
	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) +1)+low;
		
		
	}
	private int partition(int[] A,char[] B, int low, int high) {
		swap(A,B, low, getPivot(low, high));
		int border = low+1;
		for(int i = border; i <= high; i++) {
			if(A[i]>A[low]) {
				swap(A,B, i, border++);
			}
		}
		swap(A, B, low, border -1);
		return border - 1;
		
		
	}
	

}
