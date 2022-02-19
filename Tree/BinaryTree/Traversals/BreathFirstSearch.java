package Tree.BinaryTree.Traversals;

import Tree.BinaryTree.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

    public List<List<Integer>> levelOrderTraversal(Node node){
        
        if(node == null) return null;

        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> results = new LinkedList<List<Integer>>();

        queue.add(node);

        while(!queue.isEmpty()){

            int level_num = queue.size();

            List<Integer> subList = new LinkedList<Integer>();

            for(int i = 0; i < level_num; i++){
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);

                subList.add(queue.poll().data);
            }

            results.add(subList);
           
        }

        return results;
        

    }

    public int getLevelDiff(Node root)
	{
        Queue<Node> queue = new LinkedList<Node>();
	    int final_sum = root.data;

	    
	    queue.add(root);

        while(!queue.isEmpty()){
            int current_size = queue.size();

            int current_sum = 0;

            for(int i = 0; i < current_size; i++){
                if(queue.peek().left != null) current_sum += queue.peek().left.data;
                if(queue.peek().right != null) current_sum += queue.peek().right.data;

                queue.poll();
            }

            final_sum -= current_sum;
        }

        return final_sum;
	}

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

        // //ArrayList<Integer> list = treeTraversals.inOrderTraversal(rootNode); 
        // ArrayList<Integer> preorder = treeTraversals.preOrderTraversal(rootNode); 
        // System.out.println(preorder);

        List<List<Integer>> levelOrder = treeTraversals.levelOrderTraversal(rootNode);
        System.out.println(levelOrder);        
       
      

    }
}



