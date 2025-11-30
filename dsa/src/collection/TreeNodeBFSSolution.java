package collection;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeBFSSolution {
    public static int maxDepth(TreeNode root) {
        /**
         *  What is BFS?
         * - Breadth-First Search (BFS) is a graph/tree traversal algorithm.
         * - It explores nodes level by level (breadth-wise), starting from a root or source node.
         * - BFS uses a queue (FIFO) to keep track of nodes to visit next.
         *
         * How BFS Works (Step by Step)
         * - Start at the root (or source node).
         * - Put it into a queue.
         * - While the queue is not empty:
         * - Remove the front node from the queue (poll()).
         * - Process it (e.g., print value, check depth).
         * - Add all its unvisited neighbors/children to the queue (offer()).
         * - Repeat until the queue is empty.
         * **/
        Queue<TreeNode> queue = new LinkedList<>();
        //BFS - breadth First Search
        queue.offer(root);
        System.out.println(queue.size());
        int depth =0;
        while(!queue.isEmpty()) {
            int size = queue.size();;
            //process all element at current level
            for(int i=0; i< size; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            System.out.println("size after each iteration:"+queue.size());
            depth++;
        }
        System.out.println("final size:"+queue.size());
        return depth;
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
        System.out.println("Maximum Depth of Binary Tree using BFS: " + depth);
    }

}
