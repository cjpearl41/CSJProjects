public class MergeSorter {
	     
	    private int[] array;
	    private int[] tempMergArr;
	    private int length;
	    
	    private char[] array2;
	    private char[] tempMergArr2;
	   
	 
	    public MergeSorter(int[] intList, char[] alphaList) {
	    	int[] inputArr = intList;
	        System.out.println("This is the beginning of the merge sort");
	        sort(alphaList, inputArr);
	        int j=0;
	        for(int i:inputArr){
	        	
	            System.out.println(alphaList[j] + ": " +i);
	            j++;
	         
	        }
	    }
	     
	    

		public void sort(char[] alphaList, int[] inputArr) {
	        this.array = inputArr;
	        this.length = inputArr.length;
	        this.tempMergArr = new int[length];
	        
	        this.array2 = alphaList;
	        this.length = alphaList.length;
	        this.tempMergArr2 = new char[length];
	        doMergeSort(0, length - 1);
	    }
	 
	    private void doMergeSort(int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(lowerIndex, middle);
	            // Below step sorts the right side of the array
	            doMergeSort(middle + 1, higherIndex);
	            // Now merge both sides
	            mergeParts(lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
	 
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = array[i];
	            tempMergArr2[i] = array2[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] >= tempMergArr[j]) {
	                array[k] = tempMergArr[i];
	                array2[k] = tempMergArr2[i];
	                
	                i++;
	            } else {
	                array[k] = tempMergArr[j];
	                array2[k] = tempMergArr2[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempMergArr[i];
	            array2[k] = tempMergArr2[i];
	            k++;
	            i++;
	        }
	 
	    }
		

		
}

