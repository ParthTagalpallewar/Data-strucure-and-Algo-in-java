package Tree.BinaryTree.Traversals.MorrisTraversal;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

import java.util.*;

// Time Complexity = O(n) 
// Space Complexity = O(1)
public class MorrisTraversals extends BinaryTree{
    public static void main(String[] args) {

        MorrisTraversals instance = new MorrisTraversals();

        ArrayList<Integer> intraversal = instance.inorder(instance.binaryTree);
        ArrayList<Integer> pretraversal = instance.preorder(instance.binaryTree);
        
        System.out.println(intraversal);
        System.out.println(pretraversal);


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
    
    public ArrayList<Integer> preorder(Node root){

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
                     inorder.add(current.data);
                    current = current.left;
                }else{
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return inorder;
    }
}
