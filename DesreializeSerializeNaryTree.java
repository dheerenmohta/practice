import java.util.ArrayList;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
 DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
}

public class Solution {
    int pos = 1;
    public String dfs(DirectedGraphNode root){
        String ans= "";
        if(root == null){
            return ans;
        }
        ans += "[";
        ans +=String.valueOf(root.label);
        for(int i =0; i < root.neighbors.size(); i++){
            ans += dfs(root.neighbors.get(i));
        }
        ans +="]";
        return ans;
    }

    public String serialize(ArrayList<DirectedGraphNode> nodes) {
        String ans = "";
        if(nodes.size() == 0){
            return ans;
        }
        return dfs(nodes.get(0));
    }

    public UndirectedGraphNode solve(String data){
        int num = 0;
        if(data.charAt(pos) >= '0' && data.charAt(pos) <='9'){
            num *= 10;
            num += data.charAt(pos)-'0';
            pos++;
        }

        UndirectedGraphNode node = new UndirectedGraphNode(num);
        while(pos < data.length()){
            if(data.charAt(pos)== '['){
                pos++;
                node.neighbors.add(solve(data));
            }else if(data.charAt(pos)==']'){
                pos++;
                return node;
            }
        }

        return null;
    }

    // [1,3,2,4#2#3,5,6#4#5#6]
    public UndirectedGraphNode deserialize(String data) {
        if(data.length() == 0){
            return null;

        }
        return solve(data);

    }
}