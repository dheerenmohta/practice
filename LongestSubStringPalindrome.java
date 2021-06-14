static void printSubStr(String str, int low, int high)
{
	for (int i = low; i <= high; ++i)
		System.out.print(str.charAt(i));
}

// This function prints the
// longest palindrome subString
// It also returns the length
// of the longest palindrome
                           // AAA
static int longestPalSubstr(String str)
{
	// get length of input String
	int n = str.length();

	// All subStrings of length 1
	// are palindromes
	int maxLength = 1, start = 0;

	// Nested loop to mark start and end index
	
  	//   i 0 1 2
  	
	for (int i = 0; i < str.length(); i++) {
      
      // j  0 1 2
      // j    1 2
      // j      2
      
		for (int j = i; j < str.length(); j++) {
          
			int flag = 1;

			// Check palindrome
          	// k is starting from 0 to mid index is middle index       
          	for (int k = 0; k < (j - i + 1) / 2; k++)
			        // AA.(0+0) A != AA(0) A
				if (str.charAt(i + k) != str.charAt(j - k))
					flag = 0;

			// Palindrome
			     // t && 1 > 1 f. 
			     //      2 > 1 t   
			if((flag != 0) && (j - i + 1) > maxLength) {
				start = i; // 0
				maxLength = j - i + 1; // 3
			}
		}
	}

	System.out.print("Longest palindrome subString is: ");
	printSubStr(str, start, start + maxLength - 1);

	// return length of LPS
	return maxLength;
}

// Driver Code
public static void main(String[] args)
{
	String str = "AAA";
	System.out.print("\nLength is: "
		+ longestPalSubstr(str));
}