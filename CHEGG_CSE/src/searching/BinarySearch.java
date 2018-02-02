package searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Java implementation of iterative Binary Search
public class BinarySearch {
	// Returns index of x if it is present in array[], else return -1
	public static int binarySearch(int array[], int searchValue) {
		int startPos = 0, rearPos = array.length - 1;
		while (startPos <= rearPos) {
			int midPos = startPos + (rearPos - startPos) / 2;
			// Check if x is present at mid
			if (array[midPos] == searchValue)
				return midPos;
			// If searchValue greater, ignore left half
			if (array[midPos] < searchValue)
				startPos = midPos + 1;
			// If x is smaller, ignore right half
			else
				rearPos = midPos - 1;
		}
		// if we reach here, then element was not present
		return -1;
	}

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, start, mid, key);
			} else if (key > sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, mid + 1, end, key);
			} else {
				return mid;
			}
		}
		return -(start + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Limit of the Array");
		int limit = Integer.parseInt(br.readLine());
		int array[] = new int[limit];
		System.out.println("Enter the array elements:--->");
		for (int i = 0; i < limit; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("Enter the Search Value");
		int searchValue = Integer.parseInt(br.readLine());
		int position = binarySearch(array, searchValue);
		System.out.println("Element Found At Position: " + position);

		System.out.println(recursiveBinarySearch(array, 0, array.length, searchValue));
	}
}
