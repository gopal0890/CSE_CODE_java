package sorting;

//Java program for implementation of Insertion Sort
public class InsertionSort {
	/* Function to sort array using insertion sort */
	void insertionSort(int array[]) {
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			int key = array[i];
			int j = i - 1;

			// Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	// Recursive function to sort an array using insertion sort
	public void insertionSortRecursive(int arr[], int n) {
		// Base case
		if (n <= 1)
			return;

		// Sort first n-1 elements
		insertionSortRecursive(arr, n - 1);

		// Insert last element at its correct position in sorted array.
		int last = arr[n - 1];
		int j = n - 2;

		/*
		 * Move elements of arr[0..i-1], that are greater than key, to one
		 * position ahead of their current position
		 */
		while (j >= 0 && arr[j] > last) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = last;
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		int array[] = { 12, 11, 13, 5, 6 };
		InsertionSort ob = new InsertionSort();
		
		System.out.println("Insertion Sort using Iteration:----->");
		ob.insertionSort(array);
		printArray(array);
		System.out.println("Insertion Sort using Recursion:----->");
		ob.insertionSortRecursive(array, array.length);
		printArray(array);
	}
}