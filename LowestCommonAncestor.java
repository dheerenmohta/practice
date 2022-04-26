public class LowestCommonAncestor {
    private boolean foundA, foundB;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        TreeNode res = divCon(root, A, B);
        if(foundA && foundB){
            return res;
        }else{
            return null;
        }
    }

    public TreeNode divCon(TreeNode root, TreeNode A, TreeNode B){

        if(root == null){
            return root;
        }
        TreeNode left = divCon(root.left, A, B);
        TreeNode right = divCon(root.right, A, B);

        if(root == A || root == B){
            foundA = (root == A)|| foundA;
            foundB = (root == B)|| foundB;
            return root;
        }

        if(left != null && right != null){
            return root;
        }else if (left != null){
            return left;
        }else if (right != null){
            return right;
        }

        return null;

    }

}
