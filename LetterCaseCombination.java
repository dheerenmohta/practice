import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCaseCombination {

    public List<String> letterCasePermutation(String s) {
        // write your code here
        if(s==null){
            return new LinkedList<>();
        }

        Queue<String> q = new LinkedList<>();
        q.offer(s);
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                continue;
            }
            int size = q.size();
            for(int j=0; j < size; j++){

                String ch = q.poll();
                char [] chs = ch.toCharArray();
                chs[i] = Character.toLowerCase(chs[i]);
                q.offer(String.valueOf(chs));
                chs[i] = Character.toUpperCase(chs[i]);
                q.offer(String.valueOf(chs));

            }
        }

        return new LinkedList<>(q);
    }

}
