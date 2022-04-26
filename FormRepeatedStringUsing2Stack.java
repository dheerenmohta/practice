import java.util.Stack;

//Input: S = abc3[a]
//Output: "abcaaa"

public class FormRepeatedStringUsing2Stack {
    public String expressionExpand(String s) {
        // write your code here

        if(s.length()== 0){
            return "";
        }

        Stack<Integer> repeat = new Stack<>();
        Stack<String> tmpStr = new Stack<>();

        String res = "";
        int i = 0;
        while(i < s.length()){

            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = 10*count + s.charAt(i)-'0';
                    i++;
                }
                repeat.push(count);
            }else if(s.charAt(i) == '['){
                tmpStr.push(res);
                res="";
                i++;
            }else if( s.charAt(i)== ']'){
                StringBuilder sb = new StringBuilder(tmpStr.pop());
                int r = repeat.pop();
                for(int j =0; j < r ; j++){
                    sb.append(res);
                }

                res = sb.toString();
                i++;
            }else{
                res += s.charAt(i);
                i++;
            }

        }

        return res;
    }

}
