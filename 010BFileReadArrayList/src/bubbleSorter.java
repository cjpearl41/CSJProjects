
public class bubbleSorter {
	public bubbleSorter(char[] alphaList, int[] intList) {
		int i,j, temp = 0;
		char temp2;
		for(i=0;i<alphaList.length-1;i++) {
			for(j=0;j<alphaList.length-1;j++) {
				if(intList[j]<intList[j+1]){
					temp = intList[j];
					temp2 = alphaList[j];
					intList[j]=intList[j+1];
					intList[j+1]=temp;
					alphaList[j]=alphaList[j+1];
					alphaList[j+1]=temp2;
				}
			}
		}
		System.out.println("This is the start of Bubble sorting");
		for(i =0; i<alphaList.length;i++) {
			if (intList[i]>0) {
				System.out.println(alphaList[i]+"= "+intList[i]);
			}
		}
	}
	
	
	
}

