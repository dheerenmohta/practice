import java.util.Stack;

public class SimplifyLinuxPath {
    public String simplifyPath(String path) {
        // write your code here

        String [] splits = path.split("/");
        Stack<String> s= new Stack<>();
        String ans = "";

        for(String split: splits){
            if(split.length() ==0 || split.equals(".")){ continue; }
            if(split.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
                continue;
            }
            s.push(split);
        }

        while(!s.isEmpty()){ ans = "/" + s.pop()+ans;}
        if(ans.length()== 0){ans += "/"; }
        return ans;
    }

}
