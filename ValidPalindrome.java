public class ValidPalindrome {

    public boolean isAlphanumeric(char c){
        return Character.isDigit(c) || Character.isLetter(c);
    }
    public boolean isPalindrome(String s) {
        // write your code here

        if(s.length()== 0 || s == null){
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            while(left < right && !isAlphanumeric(s.charAt(left))){
                left++;
            }
            while(left < right && !isAlphanumeric(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

}
