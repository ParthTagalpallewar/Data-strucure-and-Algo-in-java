package Tree.BinaryTree.Traversals;

import java.util.*;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class BoundaryTraversal extends BinaryTree {
    public static void main(String[] args) {
        BoundaryTraversal instance = new BoundaryTraversal();
        
        ArrayList<Integer> arr = instance.boundaryTraversal(instance.binaryTree);
        
        System.out.println(arr);
    }

    public ArrayList<Integer> boundaryTraversal(Node node){

        ArrayList<Integer> arr = new ArrayList<Integer>();

        addLeftBoundary(node, arr);
        addLeftNodes(node, arr);
        addRightBoundary(node, arr);

        return arr;
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> arr){
        while(node != null){

            if(isLeafNode(node) == false) arr.add(node.data);

            if(node.left != null) node = node.left;

            else node = node.right;
        }
    }

    private void addRightBoundary(Node node, ArrayList<Integer> arr){
        Stack<Integer> stack = new Stack<Integer>();
        
        node = node.right;

        while(node != null){

            if(isLeafNode(node) == false) stack.push(node.data);

            if(node.right != null) node = node.right;

            else node = node.left;

        }

        while(!stack.isEmpty()){
            arr.add(stack.pop());
        }
    }

    private void addLeftNodes(Node node, ArrayList<Integer> arr){
        if(isLeafNode(node)){
            arr.add(node.data);
            return;
        }

        if(node.left != null) addLeftNodes(node.left, arr);
        
        if(node.right != null) addLeftNodes(node.right, arr);
    }

    private boolean isLeafNode(Node node){
        return (node.left == null) && (node.right == null);
    }
}
