package Tree.BinaryTree.Traversals;

import java.util.*;

import Tree.BinaryTree.Node;

public class SprialTransversalInTree {
    static ArrayList<Integer> findSpiral(Node root) {

        Stack<Node> stack_1 = new Stack<Node>();
        Stack<Node> stack_2 = new Stack<Node>();

        ArrayList<Integer> results = new ArrayList<Integer>();

        if (root == null)
            return results;

        stack_1.push(root);
        results.add(root.data);

        while (!stack_1.isEmpty() || !stack_2.isEmpty()) {

            while (!stack_1.isEmpty()) {

                Node curr_node = stack_1.pop();

                if (curr_node.left != null) {
                    results.add(curr_node.left.data);
                    stack_2.push(curr_node.left);
                }

                if (curr_node.right != null) {
                    results.add(curr_node.right.data);
                    stack_2.push(curr_node.right);
                }

            }

            while (!stack_2.isEmpty()) {
                Node curr_node = stack_2.pop();

                if (curr_node.right != null) {
                    results.add(curr_node.right.data);
                    stack_1.push(curr_node.right);
                }

                if (curr_node.left != null) {
                    results.add(curr_node.left.data);
                    stack_1.push(curr_node.left);
                }
            }

        }

        return results;

    }

    public static void main(String[] args) {

        Node root_node = build_tree();

        ArrayList<Integer> list = findSpiral(root_node);

        System.out.println(list);

    }

    public static Node build_tree() {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);

        root.right.right = new Node(8);
        root.right.left = new Node(6);
       

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        
       
        return root;

    }
}
