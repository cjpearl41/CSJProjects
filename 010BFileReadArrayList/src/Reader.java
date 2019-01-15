import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.stream.events.Characters;

public class Reader {

	public static void main(String[] args) {
		String alpha = "abcdefghijklmnopqrstuvwxyz0123456789.,:;?\"'[]";
		String fileName = "/home/compsci/eclipse-workspace/textfiles/Kennedy_Cuba_Crisis.txt";
		String line;
		ArrayList aList = new ArrayList();
		ArrayList<Character> bList = new ArrayList<Character>();
		char[] alphaList = new char[alpha.length()];
		int[] intList = new int[alpha.length()];
		
		
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			if(!input.ready()) {
				input.close();
				throw new IOException();
			}
			
			while((line = input.readLine()) != null){
				aList.add(line);
			}
			input.close();
		} catch(IOException e) {
			System.out.println("Error:" + e);
		}
		String fullString = String.join("", aList).toLowerCase();
		for(int j =0; j<fullString.length(); j++) {
			bList.add(fullString.charAt(j));
		}
		for(int a = 0; a<alpha.length(); a++) {
			int occurance = Collections.frequency(bList, alpha.charAt(a));
			alphaList[a] = alpha.charAt(a);
			intList[a] = occurance;
			
		
				
			
		}
		
		bubbleSorter myBubbleSorter = new bubbleSorter(alphaList, intList);
		System.out.println("");
		insertionSorter myInsertionSorter = new insertionSorter(alphaList, intList);
		System.out.println("");
		MergeSorter myMergeSorter = new MergeSorter(intList, alphaList);
		System.out.println("");
		selectionSort myselectionSorter = new selectionSort(intList, alphaList);
		System.out.println("");
		QuickSort myQuickSorter = new QuickSort(intList, alphaList);
		System.out.println("");
		
		int sz = aList.size();
		for (int i=0; i < sz; i++) {
			System.out.println(aList.get(i).toString());
		}
	}//end of main

}//end of reader
