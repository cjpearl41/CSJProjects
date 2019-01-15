import java.util.ArrayList;

public class insertion {

	public static void main(String[] args) {
		int[] list = {5,8,1,3,9,6};
		for(int i = 0;i<list.length;i++) {
			System.out.print(list[i]);
		}
		
		list = insertionSort(list);
		System.out.println("");
		for(int i = 0;i<list.length;i++) {
			System.out.print(list[i]);
		}
		

	}
	
	public static int[] insertionSort(int[] list) {
		int i, j, key, temp;
		for(i=1;i<list.length;i++) {
			key = list[i];
			j=i-1;
			while(j>=0&&key<list[j]) {
				temp=list[j];
				list[j]=list[j+1];
				list[j+1]=temp;
				j--;
			}
		}
		return list;
	}
	private static ArrayList<Integer> insertionSort(ArrayList<Integer>list){
		
		int i,j,key,temp;
		for(i=1;i<list.size();i++){
			key=list.get(i);
			j=i-1;
			while(j>=0&&key<list.get(j)) {
				temp=list.get(j);
				list.set(j, list.get(j+1));
				list.set(j+1, temp);
				j--;
			}
		}
		return list;
		

	}

}
