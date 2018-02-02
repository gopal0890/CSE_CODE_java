package sorting;

//Java program for implementation of Insertion Sort
public class InsertionSort {
	/* Function to sort array using insertion sort */
	void insertionSort(int array[]) {
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			int key = array[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
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
	public static void main(String args[]){        
		int array[] = {12, 11, 13, 5, 6};
		InsertionSort ob = new InsertionSort();        
		ob.insertionSort(array);
		printArray(array);
	}
 }