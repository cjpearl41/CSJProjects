
public class selectionSort {

	public selectionSort(int[] intList, char[] alphaList) {
		System.out.println("This is the start of the selection sort");
		int i, j, minValue,minValue2, minindex, temp=0;
		for(i=0;i<intList.length;i++) {
			minValue=intList[i];
			minValue2=alphaList[i];
			minindex=i;
			for(j=i;j<intList.length;j++) {
				if(intList[j]<minValue) {
					minValue=intList[j];
					minValue2=alphaList[j];
					minindex=j;
				}
			}
			if(minValue>intList[i]) {
				temp=intList[i];
				intList[i]=intList[minindex];
				intList[minindex]=temp;
			}
	}
	
		
		for(i =0; i<intList.length;i++) {
			if (intList[i]>0) {
				System.out.println(alphaList[i]+": "+intList[i]);
			}
		
		
		
	}
	}

}
