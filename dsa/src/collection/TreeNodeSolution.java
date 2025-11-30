package collection;

public class TreeNodeSolution {
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
//DFS - Depth first search
        /**
         * What is DFS?
         * - Depth-First Search (DFS) is a traversal algorithm for trees and graphs.
         * - It explores as far as possible along one branch before backtracking.
         * - In a binary tree, DFS means:
         * - Visit a node.
         * - Recursively explore its left subtree.
         * - Recursively explore its right subtree.
         *
         *DFS can be expressed in three common orders:
         * • 	Preorder (Root → Left → Right)
         * • 	Inorder (Left → Root → Right)
         * • 	Postorder (Left → Right → Root)
         * All are DFS — just different visitation orders.
         * **/
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;//+1 is for current node
    }

    public static void main(String[] args) {
        // Build sample tree:
        //         3
        //        / \
        //       9  20
        //          / \
        //         15  7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        // Test maxDepth
        int depth = maxDepth(root);
        System.out.println("Maximum Depth of Binary Tree: " + depth);
    }

}
