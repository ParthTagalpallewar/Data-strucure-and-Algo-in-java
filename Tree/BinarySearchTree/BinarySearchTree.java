package Tree.BinarySearchTree;

import Tree.BinaryTree.Node;
import java.util.*;

public class BinarySearchTree {
    
    public Node bst = null;

    public BinarySearchTree(){
        bst = buildBinarySearchTree();
    }


    public static void main(String[] args) {
        BinarySearchTree instance = new BinarySearchTree();
        int[] arr = {10, 5, 15, 1, 9, 11, 19};
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=0; i < arr.length; i++){
            array.add(arr[i]);
        }

        Node node = instance.buildBinarySearchTree(array);
        ArrayList<ArrayList<Integer>> traversal = instance.levelOrderTraversal(node);
        System.out.println(traversal);

        // Deleting node

        Node deletedBinaryTree = instance.deleteNode(node, 10);
        traversal = instance.levelOrderTraversal(deletedBinaryTree);
        System.out.println(traversal);

    }


    private Node buildBinarySearchTree() {
        Node root = new Node(10);

        root.left = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(9);

        root.right = new Node(15);
        root.right.left = new Node(11);
        root.right.right = new Node(19);

        return root;
    }

    public Node buildBinarySearchTree(ArrayList<Integer> array){

        Node root = new Node(array.get(0));

        for (int i = 1; i < array.size(); i++) {
            int current = array.get(i);

            addNode(root, current);

        }

        return root;

    }

    public Node buildBinarySearchTree(int[] array){

        Node root = new Node(array[0]);

        for (int i = 1; i < array.length; i++) {
            addNode(root, array[i]);
        }

        return root;

    }

    private void addNode(Node root, int num){
        Node current = root;
        while (true) {
            if (num > current.data) {
                if(current.right == null){
                    current.right = new Node(num);
                    return;    
                }else{
                    current = current.right;
                }
            }else{
                if(current.left == null){
                    current.left = new Node(num);
                    return;
                }else{
                    current = current.left;
                }

            }
        }
    }

    private Node deleteNode(Node root, int num){
        Node current = root;

        // if root node is a that is to be deleted
        if(current.data == num){
            if(current.left != null && current.right != null){
                Node prev = current.right;
                while(prev.left != null){
                    prev = prev.left;
                }
                prev.left = current.left;
                return current.right;
            }else if(current.left == null){
                return current.right;
            }else{
                return current.left;
            }
        }

        while(current != null){
            
            if(current.left != null && current.left.data == num){
                Node temp = current.left;
                if(temp.left != null && temp.right != null){
                    Node prev = temp.right;
                    while(prev.left != null){
                        prev = prev.left;
                    }
                    prev.left = temp.left;
                    current.left = temp.right;
                }else if(temp.left == null){
                    current.left = temp.right;
                }else{
                    current.left =  temp.left;
                }

                break;
            }
            
            if(current.right != null && current.right.data == num){
                Node temp = current.right;
                if(temp.left != null && temp.right != null){
                    Node prev = temp.right;
                    while(prev.left != null){
                        prev = prev.left;
                    }
                    prev.left = temp.left;
                    current.right = temp.right;
                }else if(temp.left == null){
                    current.right = temp.right;
                }else{
                    current.right =  temp.left;
                }

                break;
            }

            if(current.data < num){
                current = current.right;
            }else{
                current = current.left;
            }

        }

        return root;
    }

    public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> array = new ArrayList<>();

            for(int i=0; i<size; i++){
                Node node = queue.poll();
                array.add(node.data);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

            }

            result.add(array);
        }

        return result;
    }
}
