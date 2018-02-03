import java.util.concurrent.ThreadLocalRandom;

public class StringTools {
	private final int MAX_CHAR = 26;
	
	public static void main(String[] args) {
		StringTools sw = new StringTools();
		String str1 = "Jason";
		String str2 = "Lewis";
		// TASK:2 -> Shuffling both Strings
		String shuffled = sw.stringShuffle(str1.concat(str2));
		System.out.println("Original word:" + str1.concat(str2));
		System.out.println("Shuffled word:" + shuffled);
		System.out.println();
		
		str1 = "al";
		str2 = "white";
		shuffled = sw.stringShuffle(str1.concat(str2));
		System.out.println("Original word:" + str1.concat(str2));
		System.out.println("Shuffled word:" + shuffled);
		System.out.println();
		
		//TASK:3 -> Reverse the contents of a String
		// Reversing a concatenated String
		str1 = "Jason";
		str2 = "Lewis";
		System.out.println("Original word:" + str1.concat(str2));
		String reversedString = sw.stringReverse(str1.concat(str2));
		System.out.println("The Reversed String is: " + reversedString);
		System.out.println();
		
		// TASK:4 -> String that contains all the letters which are not found in either of the two Strings.
		str1 = "Jason";
		str2 = "Lewis";
		System.out.println("Original word:" + str1.concat(str2));
		String missingChars = sw.stringDifference(str1.concat(str2));
		System.out.println("Missing Chars are: " + missingChars.toUpperCase());
	}

	/**
	 * Shuffles a given word. Randomly swaps characters 10 times.
	 * 
	 * @param word
	 * @return
	 */
	private String stringShuffle(String word) {
		String shuffledWord = word; // start with original
		int wordSize = word.length();
		int shuffleCount = 10; // let us randomly shuffle letters 10 times
		for (int i = 0; i < shuffleCount; i++) {
			// swap letters in two indexes
			int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
			int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
			shuffledWord = swapCharacters(shuffledWord, position1, position2);
		}
		return shuffledWord;
	}

	/**
	 * Swaps characters in a string using the given character positions
	 * 
	 * @param shuffledWord
	 * @param position1
	 * @param position2
	 * @return
	 */
	private String swapCharacters(String shuffledWord, int position1, int position2) {
		char[] charArray = shuffledWord.toCharArray();
		// Replace with a "swap" function, if desired:
		char temp = charArray[position1];
		charArray[position1] = charArray[position2];
		charArray[position2] = temp;
		return new String(charArray);
	}
	
	/**
	 * Reverses characters in a string using the given character positions
	 * 
	 * @param originalString
	 * @return reversedString
	 */
	private String stringReverse(String originalString){
		String temp = "";
		for(int i=originalString.length() - 1; i >=0; i--){
			char ch = originalString.charAt(i);
			temp += ch;
		}
		return temp;
	}
	
	/**
	 * Find all the missing characters in a string
	 * 
	 * @param originalString
	 * @return reversedString
	 */
	private String stringDifference(String originalString){
	    // A boolean array to store characters present in string.
	    boolean present[] = new boolean[MAX_CHAR];
	 
	    // Traverse string and mark characters present in string.
	    for (int i=0; i<originalString.length(); i++){
	        if (originalString.charAt(i) >= 'a' && originalString.charAt(i) <= 'z')
	            present[originalString.charAt(i)-'a'] = true;
	        else if (originalString.charAt(i) >= 'A' && originalString.charAt(i) <= 'Z')
	            present[originalString.charAt(i)-'A'] = true;
	    }
	    
	    // Store missing characters in alphabetic order.
	    String resultantString = "";
	    for (int i=0; i<MAX_CHAR; i++)
	        if (present[i] == false)
	        	resultantString = resultantString + ((char)(i+'a'));
	 
	    return resultantString;
	}
}