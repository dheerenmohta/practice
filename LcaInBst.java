// Recursive Java program to print lca of two nodes

// A binary tree node
class Node
{
        int data;
        Node left, right;

        Node(int item)
        {
                data = item;
                left = right = null;
        }
}

class BinaryTree
{
        Node root;
        
        /* Function to find LCA of n1 and n2. The function assumes that both
        n1 and n2 are present in BST */
            //  tree 20     10     14
        Node lca(Node node, int n1, int n2)
        {
            // 20 == null
                if (node == null)
                        return null;

                // If both n1 and n2 are smaller than root, then LCA lies in left
        // 20 > 10         &&        20 > 14
                if (node.data > n1 && node.data > n2)
            {              // 8       10  14
                           
                            return lca(node.left, n1, n2);
            }
                // If both n1 and n2 are greater than root, then LCA lies in right
                8 < 10  && 8 < 14
        if (node.data < n1 && node.data < n2)
                        {   //          12         10  14
                return lca(node.right, n1, n2);
            }
                //12
                return node;
        }

        /* Driver program to test lca() */
        public static void main(String args[])
        {
                // Let us construct the BST shown in the above figure
                BinaryTree tree = new BinaryTree();
                tree.root = new Node(20);
                tree.root.left = new Node(8);
                tree.root.right = new Node(22);
                tree.root.left.left = new Node(4);
                tree.root.left.right = new Node(12);
                tree.root.left.right.left = new Node(10);
                tree.root.left.right.right = new Node(14);

                int n1 = 10, n2 = 14;
                            // 20,   10  14
                Node t = tree.lca(tree.root, n1, n2);
                System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

                n1 = 14;
                n2 = 8;
                t = tree.lca(tree.root, n1, n2);
                System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

                n1 = 10;
                n2 = 22;
                t = tree.lca(tree.root, n1, n2);
                System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        }
}


//     20
//     8    22
//   4   12
//      10 14
