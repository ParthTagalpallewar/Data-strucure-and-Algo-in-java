package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTree;
import Tree.BinaryTree.Node;

public class Ceil extends BinarySearchTree {
    public static void main(String[] args) {
        Ceil instance = new Ceil();
        Node ceil_node = instance.getFloor(instance.bst, 12);
        System.out.println(ceil_node);
    }

    public Node getCeil(Node root, int num){
        Node saved = null;
        Node current = root;

        while(current != null){
            
            if(num == current.data){
                saved = current;
                break;
            }

            if(num < current.data){
                saved = current;
                current = current.left;
            }else{
                current = current.right;
            }


        }
        return saved;
    }

    public Node getFloor(Node root, int num){
        Node current = root;
        Node saved = null;
        while(current != null){

            if(num == current.data) return current;

            if(num > current.data){
                saved = current;
                current = current.right;
            }else{
                current = current.left;
            }
        }
        return saved;
    }
}
