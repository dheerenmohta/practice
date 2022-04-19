class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i=0;i<s.length();i++){
            max = Math.max(max,helper(s,i,new HashSet<>(),0));
        }
        return max;
    }

    public static int helper(String s, int i, HashSet<Character> set, int count){
        if (i==s.length() || set.contains(s.charAt(i))) return count;
        else {
            set.add(s.charAt(i));
            return helper(s,i+1,set,count+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaa"));
    }
}