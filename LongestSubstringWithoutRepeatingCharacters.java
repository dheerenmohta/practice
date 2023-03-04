class Solution {
    public int lengthOfLongestSubstring(String s) {

    int [] index = new int[128];
    int maxLength = 0;

    for(int i =0, j =0; j<s.length(); j++){
        
        i = Math.max(index[s.charAt(j)], i);
        maxLength = Math.max(maxLength, j-i+1);
        // i always points to the next character after the last occurrence of the current character in the current substring,
        // which guarantees that the current substring does not contain any repeating characters.
        index[s.charAt(j)] = j+1;

    }

    return maxLength;

    }
}
