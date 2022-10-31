package Tree.BinaryTree.Questions;


import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class MaxPathSum extends BinaryTree {
    public static void main(String[] args) {
        MaxPathSum instance = new MaxPathSum();
        int[] maxpathsum = new int[1];
        instance.maxPathSum(instance.binaryTree, maxpathsum);
        System.out.println("Max path sum is " + maxpathsum[0]);
    }

    public int maxPathSum(Node root, int[] sum){
        if(root == null) return 0;

        int lh = maxPathSum(root.left, sum);
        int rh = maxPathSum(root.right, sum);

        int curr = root.data + lh + rh;
        
        sum[0] = Math.max(sum[0], curr);

        return curr;

    }
}
