package Tree.BinaryTree.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Tree.BinaryTree.Node;


public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder order = new LevelOrder();
        Node root = order.buildBinaryTree();

        ArrayList<ArrayList<Integer>> bfs = order.levelOrderTraversal(root);
        System.out.println(bfs);

        ArrayList<Integer> preorder = order.InOrder(root);
        System.out.println(preorder);

    }

    public Node buildBinaryTree(){

        Node rootNode = new Node(1);

        rootNode.left = new Node(2);
        rootNode.right = new Node(3);

        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);

        rootNode.right.left = new Node(6);
        rootNode.right.right = new Node(7);

        return rootNode;

    }

    public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root){

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        
        if(root == null) return null;

        queue.add(root);

        while(!queue.isEmpty()){
            
            ArrayList<Integer> subList = new ArrayList<Integer>();
            int size = queue.size();

            for(int i=0; i<size; i++){

                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);

                subList.add(queue.poll().data);
            }

            result.add(subList);

        }

        return result;

    }

    public ArrayList<Integer> preOrder(Node root){

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>(); 

        Node current_node = root;
        stack.push(current_node);

        while(!stack.isEmpty()){
            current_node = stack.pop();
            result.add(current_node.data);
            
            if(current_node.right != null){
                stack.push(current_node.right);
            }

            if(current_node.left != null){
                stack.push(current_node.left);
            }
        }

        return result;
    }

    public ArrayList<Integer> InOrder(Node root){

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>(); 

        Node current_node = root;
        

        while(true){
            if(current_node != null){
                stack.add(current_node);
                current_node = current_node.left;
            }else{
                if(stack.isEmpty()) break;
                current_node = stack.pop();
                result.add(current_node.data);
                current_node = current_node.right;
            }
        }

        return result;
    }

    public ArrayList<Integer> postOrder(Node root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>(); 

        Node current_node = root;
        stack.push(current_node);

        while(!stack.isEmpty()){

            if(current_node == null && stack.isEmpty()){
                break;
            }

            if(current_node == null){
                current_node = stack.pop();
                result.add(current_node.data);
                
            }

            if (current_node.right != null) {
                stack.push(current_node.right);
            }

            if(current_node.left != null){
                stack.push(current_node.left);
                current_node = current_node.left;
            }
           
            
            

        }

        return result;
    }

}
