import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationOfPhoneNumberString {

    public static final HashMap <Integer, String> PHONE = new HashMap<Integer, String>(){
        {
            put(0,"");
            put(1,"");
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }

    };

    public List<String> letterCombinations(String digits) {
        // write your code here

        List<String> result = new ArrayList<>();
        if(digits.length()== 0){return result;}
        dfs(0,"",digits,PHONE, result);
        return result;


    }

    public static void dfs(int index, String current, String digits, HashMap<Integer, String> PHONE, List<String> result ){

        if(index == digits.length()){
            result.add(current);
            return;
        }
        int d = digits.charAt(index)-'0';

        for(char c : PHONE.get(d).toCharArray()){
            dfs(index+1, current+c, digits, PHONE, result);
        }

    }
}
