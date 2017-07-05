package linkedin;

public class BitDifference {
	public static void main(String args[]){
		int arr[] = {1, 3, 5};
		System.out.println("Sum = " + sumOfPairwiseBitDifference(arr));
	}
	
	public static int sumOfPairwiseBitDifference(int arr[]) {
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = 0 ; j < arr.length; j++) {
				sum += returnSumOfBitDifferences(arr[i], arr[j]);
			}
		}
		return sum;
	}
	
	// Given two numbers, finds the bit difference
	public static int returnSumOfBitDifferences(int number1, int number2) {
		String binary1 = getBinaryRepresentation(number1);
		String binary2 = getBinaryRepresentation(number2);
		int sum = 0;
		for (int i = 0 ; i < binary1.length(); i++) 
			sum += binary1.charAt(i) != binary2.charAt(i) ? 1 : 0;
		return sum;
	}
	
	// Convert all binary representations to 32 bit for consistency
	public static String padWithZeroes(String binary) {
		int padlength = 32 - binary.length();
		String pad = new String();
		for (int i = 0 ; i < padlength; i++) 
			pad += "0";
		return pad + binary;
	}
	
	public static String getBinaryRepresentation(Integer number) {
		return padWithZeroes(Integer.toBinaryString(number));
	}
}
