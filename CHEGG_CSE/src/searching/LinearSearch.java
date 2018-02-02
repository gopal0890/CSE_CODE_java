package searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Linear Search Implementation in Java
public class LinearSearch {
	
	// This function returns index of element x in arr[]
	public static int search(int array[], int limit, int searchValue) {
		for (int i = 0; i < limit; i++) {
			// Return the index of the element if the element is found
			if (array[i] == searchValue)
				return i;
		}
		// return -1 if the element is not found
		return -1;
	}
	
	// Recursive Method to search x in arr[l..r]
    public static int recursiveSearch(int array[], int startPos, int rearPos, int searchValue){
         if (rearPos < startPos)
            return -1;
         if (array[startPos] == searchValue)
            return startPos;
         return recursiveSearch(array, startPos+1, rearPos, searchValue);
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Limit of the Array");
		int limit = Integer.parseInt(br.readLine());
		int array[] = new int[limit];
		System.out.println("Enter the array elements:--->");
		for(int i=0;i<limit;i++){
			array[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("Enter the Search Value");
		int searchValue = Integer.parseInt(br.readLine());
		int position = search(array, limit, searchValue);
		System.out.println("Element Found At Position: " + position);
		
		System.out.println(recursiveSearch(array, 0, array.length-1, searchValue));
	}
}
