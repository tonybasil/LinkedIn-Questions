package linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubArray {
	public static void main(String args[]){
		int arr[] = {1,56,58,57,90,92,94,93,91,45};
		System.out.println("Longest Sequence : " + findLongestSequence(arr));
	}
	
	public static int findLongestSequence(int numbers[]){
		Map<Integer, Integer> numbermap = returnNumberMap(numbers);
		numbermap = new TreeMap<Integer, Integer>(numbermap); // Sort the map of input numbers
		int longestsequencecount = 0;
		int currentsequencecount = 0;
		for ( Integer key : numbermap.keySet() ) {
			/* If the element represents start of a sequence, reset the sequence count (currentsequencecount) and set longest count
			 to the max (longestsequencecount, currentsequencecount) */
			if (isStartOfSequence(numbermap, key)) {
				currentsequencecount = currentsequencecount > longestsequencecount ? currentsequencecount : longestsequencecount;
				currentsequencecount = 0;
			}
			currentsequencecount++;
		}
		longestsequencecount = currentsequencecount > longestsequencecount ? currentsequencecount : longestsequencecount;
		return longestsequencecount;
	}
	
	
	// Tells whether a given array element represents the start of a Sequence
	public static boolean isStartOfSequence(Map<Integer, Integer> numbermap, int number) {
		return numbermap.get(number - 1) == null ? true : false;
	}
	
	// Convert array of numbers to hashmap
	public static Map<Integer, Integer> returnNumberMap(int numbers[]) {
		Map<Integer, Integer> numbermap = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < numbers.length; i++) 
			numbermap.put(numbers[i], numbers[i]);
		return numbermap;
	}

}
