package sorting;

public class BubbleSort {

	// Bubble Sort Implementation in Java using Iteration
	public void bubbleSort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++){
			for (int j = 0; j < n - i - 1; j++){
				if (array[j] > array[j + 1]) {
					// swap temp and arr[i]
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// Bubble Sort Implementation in Java using Recursion
	public void bubbleSort(int array[], int limit) {
		// Base case
		if (limit == 1)
			return;

		// One pass of bubble sort. After this pass, the largest element is
		// moved (or bubbled) to end.
		for (int i = 0; i < limit - 1; i++)
			if (array[i] > array[i + 1]) {
				// swap arr[i], arr[i+1]
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		bubbleSort(array, limit - 1);
	}

	/* Prints the array */
	void printArray(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	// Driver method to test above
	public static void main(String args[]) {
		BubbleSort ob = new BubbleSort();
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		ob.bubbleSort(arr);
		System.out.println("Sorted array using Iterative Bubble Sort:----->");
		ob.printArray(arr);
		
		ob.bubbleSort(arr, arr.length);
		System.out.println("Sorted array using Recursive Bubble Sort:----->");
		ob.printArray(arr);
		
	}
}
