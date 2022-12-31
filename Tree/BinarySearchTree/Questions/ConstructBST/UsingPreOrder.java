package Tree.BinarySearchTree.Questions.ConstructBST;

import Tree.BinarySearchTree.BinarySearchTree;
import Tree.BinaryTree.Node;
import java.util.*;

public class UsingPreOrder extends BinarySearchTree{
    public static void main(String[] args) {
        UsingPreOrder instance = new UsingPreOrder();
        int[] pre_order = {8, 5, 1, 7, 10, 12};
        Node binaryTree = instance.buildBinaryTree(pre_order);
        ArrayList<ArrayList<Integer>> level_order = instance.levelOrderTraversal(binaryTree);
        System.out.println(level_order);
    }

    public Node buildBinaryTree(int[] arr){
        Stack<Node> stack = new Stack<Node>();
        Node root = new Node(arr[0]);
        stack.push(root);
        int counter = 1;

        Node current_node = root;
        while (counter < arr.length) {
            
            if(arr[counter] < current_node.data){
                Node left_node = new Node(arr[counter]);
                current_node.left = left_node;
                stack.push(left_node);
                current_node = current_node.left;
                counter += 1;
            }else{

                while(!stack.isEmpty() && stack.firstElement().data < arr[counter]){
                    current_node = stack.pop();
                }
                Node right_node = new Node(arr[counter]);
                current_node.right = right_node;
                stack.push(right_node);
                current_node = right_node;
                counter += 1;
            }

        }
        return root;
    }
}
