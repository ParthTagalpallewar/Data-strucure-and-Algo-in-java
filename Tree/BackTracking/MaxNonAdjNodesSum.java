package Tree.BackTracking;

import Tree.BinaryTree.Node;

class MaxNonAdjNodesSum{
    public static void main(String[] args) {
        Node rootNode = getTree();

        int maxSum = getMaxSum(rootNode);

        System.out.println(maxSum);

    }

    public static Node getTree(){
        Node rootNode = new Node(11);

        rootNode.left = new Node(1);
        rootNode.right = new Node(2);

        return rootNode;

    }

    static int getMaxSum(Node root) {
        if (root == null)
            return 0;

        int sum_left_right = getMaxSum(root.left);

        if (root.right != null){
            sum_left_right += getMaxSum(root.right.left);
            sum_left_right += getMaxSum(root.right.right);

        }

        int sum_right_left = getMaxSum(root.right);
        if (root.left != null){
            sum_right_left += getMaxSum(root.left.left);
            sum_right_left += getMaxSum(root.left.right);
        }
        return Math.max(sum_left_right, sum_right_left);
    }
}
