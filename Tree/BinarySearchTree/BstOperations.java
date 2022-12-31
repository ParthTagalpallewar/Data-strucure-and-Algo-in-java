package Tree.BinarySearchTree;

import Tree.BinaryTree.Node;

public class BstOperations extends BinarySearchTree {
    public static void main(String[] args) {
        BstOperations instance = new BstOperations();
        Node node = instance.search(instance.bst, 15);
        System.out.println(node);
    }

    public Node search(Node root, int num){
        Node current = root;

        while(current != null){

            if(current.data == num) return current;

            if(current.left == null && current.right == null) return null;

            if(current.data > num) current = current.left;

            else current = current.right;

        }

        return current;
    }


}
