package Tree.BinaryTree;

import Tree.BinaryTree.Traversals.BreathFirstSearch;

public class MaxDepth extends BinaryTree {
    public static void main(String[] args) {
        MaxDepth instance = new MaxDepth();


        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        traversals.inOrderTraversal(instance.binaryTree);

        int height = instance.countHeight(instance.binaryTree);
        System.out.println();
        System.out.println(height);
    }

    public  int countHeight(Node node){

        if(node.left != null && node.right != null){
            int leftHeight = 1 + countHeight(node.left);
            int rightHeight = 1 + countHeight(node.right);

            return Math.max(leftHeight, rightHeight);
        }

        else if(node.left != null) return 1 + countHeight(node.left);
       
        else if(node.right != null) return 1 + countHeight(node.right);

        else
            return 1; 
    }


}
