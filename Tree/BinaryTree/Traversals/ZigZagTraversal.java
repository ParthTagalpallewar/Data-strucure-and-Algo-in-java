package Tree.BinaryTree.Traversals;

import java.util.*;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class ZigZagTraversal extends BinaryTree{
    public static void main(String[] args) {
        ZigZagTraversal instance = new ZigZagTraversal();

        ArrayList<Integer> arr = instance.zigzag(instance.binaryTree);

        System.out.println(arr);
    }

    public ArrayList<Integer> zigzag(Node root){
        
        ArrayList<Integer> arr = new ArrayList<Integer>();

        if(root == null) return arr;

        // code started here
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        boolean fromLeft = true;

        s1.add(root);

        while(!s1.isEmpty() || !s2.isEmpty()){

            if(fromLeft){

                int size = s1.size();

                for (int i = 0; i < size; i++) {
                    
                    Node curr = s1.pop();

                    arr.add(curr.data);

                    if(curr.left != null) s2.push(curr.left);

                    if(curr.right != null) s2.push(curr.right);

                }


            }

            else{
                int size = s2.size();

                for (int i = 0; i < size; i++) {
                    
                    Node curr = s2.pop();

                    arr.add(curr.data);

                    if(curr.right != null) s1.push(curr.right);

                    if(curr.left != null) s1.push(curr.left);

                    
                }
            }
        
            fromLeft = !fromLeft;
        }


        return arr;
    }
}
