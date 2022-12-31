package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTree;
import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class CheckBST extends BinarySearchTree {
    public static void main(String[] args) {
        
        CheckBST instance = new CheckBST();

        BinaryTree binaryTree = new BinaryTree();
        // boolean isBst = instance.isBinarySearchTree(binaryTree.binaryTree);
        boolean isBst = instance.isBinarySearchTree(instance.bst);
        System.out.println(isBst);


    }

    public boolean isBinarySearchTree(Node root){
        
        boolean leftCond = (root.left == null) ?  true : root.left.data < root.data;
        boolean rightCond = (root.right == null) ? true : root.right.data > root.data;

        if(leftCond && rightCond){

            if(root.left != null && root.right != null) return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);

            else if(root.left != null) return isBinarySearchTree(root.left);

            else if(root.right != null) return isBinarySearchTree(root.right);

            else return true;
        }else{
            return false;
        }
    }
}
