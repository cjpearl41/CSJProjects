
public class selectionSort {

	public static void main(String[] args) {
		int[] list = {5,8,1,6,9,2};
		for(int i = 0;i<list.length;i++) {
			System.out.print(list[i]);
		}
		
		list = selectionSort(list);
		System.out.println("");
		for(int i = 0;i<list.length;i++) {
			System.out.print(list[i]);
		}

	}
	public static int[] selectionSort(int[] list) {
		int i, j, minValue, minindex, temp=0;
		for(i=0;i<list.length;i++) {
			minValue=list[i];
			minindex=i;
			for(j=i;j<list.length;j++) {
				if(list[j]<minValue) {
					minValue=list[j];
					minindex=j;
				}
			}
			if(minValue<list[i]) {
				temp=list[i];
				list[i]=list[minindex];
				list[minindex]=temp;
			}
			
		}
		
		
		
		
		
		return list;
	}

}
