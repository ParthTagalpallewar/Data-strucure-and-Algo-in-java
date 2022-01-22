package Tree.BinaryTree.Traversals;

import Tree.BinaryTree.Node;
import java.util.ArrayList;
import java.util.Stack;

public class BreathFirstSearch {
    

    public ArrayList<Integer> inOrderTraversal(Node node){

        if(node == null) return null;

        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();

        Node current_node = node;

        while(!stack.isEmpty() || current_node != null){

            if(current_node != null){
                stack.push(current_node);
                current_node = current_node.left;
            }else{
                Node n = stack.pop();
                array.add(n.data);
                current_node = n.right;
            }

        }

        return array;

    }

    public ArrayList<Integer> preOrderTraversal(Node node){

        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();

        Node currentNode = node;

        while(!stack.isEmpty() || currentNode != null){

            if(currentNode != null){
                array.add(currentNode.data);
                stack.add(currentNode);
                currentNode = currentNode.left; 
            }
            else{
                Node n = stack.pop();
                currentNode = n.right;
            }

        }

        return array;

    }

    // public ArrayList<Integer> postOrderTraversal(Node node){
        
    //     ArrayList<Integer> array = new ArrayList<Integer>();
    //     Stack<Node> stack = new Stack<Node>();

    //     Node currentNode = node;

        

    // }

    public Node buildBinaryTree(){

        Node rootNode = new Node(10);

        rootNode.left = new Node(5);
        rootNode.right = new Node(15);

        rootNode.left.left = new Node(1);
        rootNode.left.right = new Node(9);

        rootNode.right.left = new Node(11);
        rootNode.right.right = new Node(19);

        return rootNode;

    }

    public static void main(String[] args) {
        
        BreathFirstSearch treeTraversals = new BreathFirstSearch();
        Node rootNode = treeTraversals.buildBinaryTree();

        //ArrayList<Integer> list = treeTraversals.inOrderTraversal(rootNode); 
        ArrayList<Integer> preorder = treeTraversals.preOrderTraversal(rootNode); 
        System.out.println(preorder);

    }
}



