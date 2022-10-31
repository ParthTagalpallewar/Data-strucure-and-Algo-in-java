package Tree.BinaryTree.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Tree.BinaryTree.Node;
public class BinaryTreeIterative {
    public static void main(String[] args) {
        BinaryTreeIterative order = new BinaryTreeIterative();
        Node root = order.buildBinaryTree();

        ArrayList<ArrayList<Integer>> bfs = order.levelOrderTraversal(root);
        System.out.println(bfs);

        ArrayList<Integer> preorder = order.postOrderTraversalType2(root);
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

    public ArrayList<Integer> preOrderTraversal(Node root){

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();

        stack.addElement(root);

        while(!stack.isEmpty()){

            Node curr = stack.pop();
            list.add(curr.data);

            if(curr.right != null) stack.push(curr.right);

            if(curr.left != null) stack.push(curr.left);
        }

        return list;
    }

    public ArrayList<Integer> inOrderTraversal(Node root){

        Node curr = root;
        Stack<Node> stack = new Stack<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(true){
            if(curr.left != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{

                list.add(curr.data);

                if(stack.isEmpty()) break;

                curr = stack.pop();

                list.add(curr.data);

                if(curr.right != null) curr = curr.right;

            }
        }

        return list;

    }

    public ArrayList<Integer> postOrderTraversalType1(Node root){
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();

       
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);

            if(root.left != null) s1.push(root.left);

            if(root.right != null) s1.push(root.right);
            
            
        }

        while (!s2.isEmpty()) {
            list.add(s2.pop().data);
        }

        return list;
    }

    public ArrayList<Integer> postOrderTraversalType2(Node root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();

        if(root == null) return list;

        Node pre = null;

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                root = stack.peek();

                if(root.right == null || root.right == pre){
                    list.add(root.data);
                    stack.pop();
                    pre = root;
                    root = null;
                }else{
                    root = root.right;
                }
            }
        }

        return list;
    }
}

