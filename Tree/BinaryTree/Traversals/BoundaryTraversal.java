package Tree.BinaryTree.Traversals;

import java.util.*;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class BoundaryTraversal extends BinaryTree {
    public static void main(String[] args) {
        BoundaryTraversal instance = new BoundaryTraversal();
        
        ArrayList<Integer> arr = instance.boundaryTraversal1(instance.binaryTree);
        
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

    public ArrayList<Integer> boundaryTraversal1(Node node){
        ArrayList<Integer> result = new ArrayList<Integer>();

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Node curr = queue.poll();

                if(isLeafNode(curr) || i==0 || i==size-1) result.add(curr.data);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        return result;
    }
}
/* 
        1
    2       3

4      5 6      7

traversal -> 1 2 4 5 6 7 3 1
  
*/

/* */