import javax.swing.tree.TreeNode;

public class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class InOrderSuccesorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode cand = null;

        while(root != null){
            if(p.val >= root.val){
                root = root.right;
            }else{
                cand = root;
                root = root.left;
            }
        }
        return cand;
    }

}
