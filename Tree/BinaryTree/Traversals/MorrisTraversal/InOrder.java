package Tree.BinaryTree.Traversals.MorrisTraversal;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

import java.util.*;

public class InOrder extends BinaryTree{
    public static void main(String[] args) {

        InOrder instance = new InOrder();

        ArrayList<Integer> traversal = instance.inorder(instance.binaryTree);
        
        System.out.println(traversal);


    }

    public ArrayList<Integer> inorder(Node root){

        ArrayList<Integer> inorder = new ArrayList<Integer>();
        Node current = root;

        while (current != null) {
            if(current.left == null){
                inorder.add(current.data);
                current = current.right;
            }else{

                // Find Right most of left subtree
                Node prev = current.left;

                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                }else{
                    prev.right = null;
                    inorder.add(current.data);
                    current = current.right;
                }
            }
        }

        return inorder;
    }
}
