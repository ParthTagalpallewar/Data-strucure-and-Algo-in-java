package Tree.BinaryTree.Traversals;

import Tree.BinaryTree.Node;

public class RecursiveTraversals {

    public void inOrderTraversal(Node root){
        if(root.left != null) inOrderTraversal(root.left);

        System.out.print(root.data + " -> ");

        if(root.right != null) inOrderTraversal(root.right);
    }

    public void preOrderTraversal(Node root){
        System.out.print(root.data + " -> ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root){
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " -> ");
    }
}
