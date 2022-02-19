package Tree;

import java.util.*;

import Tree.BinaryTree.Node;

public class a {
    static ArrayList<Integer> findSpiral(Node root) {

        Stack<Node> stack = new Stack<Node>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        stack.push(root);
        result.add(root.data);

        boolean from_left = true;

        while (!stack.isEmpty()) {

            int stack_size = stack.size();


            if (from_left) {

                
                for (int i = 0; i < stack_size; i++) {

                    Node current = stack.pop();

                    if (current.left != null) {
                        result.add(current.left.data);
                        stack.push(current.left);
                    }

                    if (current.right != null) {
                        result.add(current.right.data);
                        stack.push(current.right);
                    }

                   
                }

                from_left = !from_left;

            } else {
                for (int i = 0; i < stack_size; i++) {

                    Node current = stack.pop();

                    if (current.right != null) {
                        result.add(current.right.data);
                        stack.push(current.right);
                    }

                    if (current.left != null) {
                        result.add(current.left.data);
                        stack.push(current.left);
                    }
                }

                from_left = !from_left;

            }


        }

        return result;

    }

    public static void main(String[] args) {

        Node root_node = build_tree();

        ArrayList<Integer> list = findSpiral(root_node);

        System.out.println(list);

    }

    public static Node build_tree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(7);
        root.left.right = new Node(6);

        root.right.left = new Node(5);
        root.right.right = new Node(4);

        return root;

    }
}
