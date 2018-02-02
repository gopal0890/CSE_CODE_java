package sorting;

// Merge Sort Implementation using Java
public class MergeSort {
	
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int startPos, int midPos, int rearPos) {
		// Find sizes of two subarrays to be merged
		int n1 = midPos - startPos + 1;
		int n2 = rearPos - midPos;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[startPos + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[midPos + 1 + j];

		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = startPos;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using merge()
	void sort(int arr[], int startPos, int rearPos) {
		if (startPos < rearPos) {
			// Find the middle point
			int midPos = (startPos + rearPos) / 2;

			// Sort first and second halves
			sort(arr, startPos, midPos);
			sort(arr, midPos + 1, rearPos);

			// Merge the sorted halves
			merge(arr, startPos, midPos, rearPos);
		}
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
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array using Merge Sort is:------>");
		printArray(arr);
	}
}