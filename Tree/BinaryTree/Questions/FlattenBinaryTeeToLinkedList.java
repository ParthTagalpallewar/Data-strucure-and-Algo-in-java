package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

// Does with help of morris traversal
public class FlattenBinaryTeeToLinkedList extends BinaryTree{
    public static void main(String[] args) {
        FlattenBinaryTeeToLinkedList instance = new FlattenBinaryTeeToLinkedList();

        Node root = instance.binaryTreeToLinkedList(instance.binaryTree);

        Node current = root;
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.right;
        }
    }

    public Node binaryTreeToLinkedList(Node root){
        Node current = root;

        while(current != null){

            if(current.left != null){
                
                Node prev = current.left;
                while(prev.right != null){
                    prev = prev.right;
                }

                prev.right = current.right;
                current.right = current.left;
            }

            current = current.right;
        }

        return root;
    }
}
