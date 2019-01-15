
public class insertionSorter {
	public insertionSorter(char[] alphaList, int[] intList) {
		int i, j, key, temp;
		char temp2;
		for(i=1;i<alphaList.length;i++) {
			key =	intList[i];
			j=i-1;
			while(j>=0&&key>intList[j]) {
				temp=intList[j];
				intList[j]=intList[j+1];
				intList[j+1]=temp;
				temp2=alphaList[j];
				alphaList[j]=alphaList[j+1];
				alphaList[j+1]=temp2;
				j--;
			}
		}
		System.out.println("This is the start of insertion sorting");
		for(i =0; i<alphaList.length;i++) {
			if (intList[i]>0) {
				System.out.println(alphaList[i]+"= "+intList[i]);
			}
			
		}
	}
}


