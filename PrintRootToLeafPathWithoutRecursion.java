// Java program to Print root to leaf path WITHOUT
// using recursion
import java.util.Stack;
import java.util.HashMap;
public class PrintPath {

        /* Function to print root to leaf path for a leaf
        using parent nodes stored in map */ 
                                               // 8         // 10->null
                                                            // 20->10
                                                            // 8->10 
        public static void printTopToBottomPath(Node curr, HashMap<Node,Node> parent)
        {
                Stack<Node> stk=new Stack<>() ;
        
                // start from leaf node and keep on pushing
                // nodes into stack till root node is reached
                8 != null
                while (curr!=null)
                {   
            // [8]
                        stk.push(curr);
            curr = parent.get(curr);// 10
                }
        
                // Start popping nodes from stack and print them

                while (!stk.isEmpty())
                { 
                        curr = stk.pop();// 8
                        System.out.print(curr.data+" ");
                }
                System.out.println();
        }


        /* An iterative function to do preorder traversal
        of binary tree and print root to leaf path
        without using recursion */
                                        // 10
        public static void printRootToLeaf(Node root)
        {
                // Corner Case
                if (root == null)
                        return;
        
                // Create an empty stack and push root to it
                Stack<Node> nodeStack=new Stack<>();
        // [10]
                nodeStack.push(root);
        
                // Create a map to store parent pointers of binary
                // tree nodes
        //
                HashMap<Node,Node> parent=new HashMap<>();
        

                // parent of root is NULL
                // 10->null
        parent.put(root,null);
        
                /* Pop all items one by one. Do following for
                every popped item
                        a) push its right child and set its parent
                        pointer
                        b) push its left child and set its parent
                        pointer
                Note that right child is pushed first so that
                left is processed first */
                while (!nodeStack.isEmpty())
                {
                        // Pop the top item from stack
                    // 10
                        Node current = nodeStack.pop();
        
                        // If leaf node encountered, print Top To
                        // Bottom path
            //   
                        if (current.left==null && current.right==null)
                                       // 8     // 10->null
                                                // 20->10
                                                // 8->100 
                                printTopToBottomPath(current, parent);
        
                        // Push right & left children of the popped node
                        // to stack. Also set their parent pointer in
                        // the map
            //   20 != null
                        if (current.right!=null)
                        {              // 10->null
                            // 20->10
                                parent.put(current.right,current);
                //   [20
                //    10]
                                nodeStack.push(current.right);
                        }
                        if (current.left!=null)
                        {               // 10->null
                            // 20->10
                            // 8->10
                                parent.put(current.left,current);
                            //  [8
                            //  20
                            //  10]
                                nodeStack.push(current.left);
                        }
                }
        }


        public static void main(String args[]) {
                Node root=new Node(10);
                root.left = new Node(8);
                root.right = new Node(20);
                root.left.left = new Node(3);
                root.left.right = new Node(5);
                root.right.left = new Node(2);
                printRootToLeaf(root);
        }
}

/* A binary tree node */
class Node
{
        int data;
        Node left, right;
        Node(int data)
        {
                left=right=null;
                this.data=data;
        }
};

            10
           8   20
         3  5 2 
           
