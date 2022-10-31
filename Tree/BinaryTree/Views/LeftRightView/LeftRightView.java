package Tree.BinaryTree.Views.LeftRightView;

import java.util.ArrayList;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class LeftRightView extends BinaryTree{
    public static void main(String[] args) {

        LeftRightView instance = new LeftRightView();

        ArrayList<Integer> leftView = instance.leftView(instance.binaryTree);
        ArrayList<Integer> rightView = instance.rightView(instance.binaryTree);
        
        System.out.println(leftView);
        System.out.println(rightView);

    }

    public ArrayList<Integer> leftView(Node node){
        ArrayList<Integer> result = new ArrayList<Integer>();

        Node current = node;
        
        while(current != null){
            result.add(current.data);

            if(current.left != null){
                current = current.left;
            }

            else{
                current = current.right;
            }
        }

        return result;
    }

    public ArrayList<Integer> rightView(Node node){
        ArrayList<Integer> result = new ArrayList<Integer>();

        Node current = node;
        
        while(current != null){
            result.add(current.data);

            if(current.right != null){
                current = current.right;
            }

            else{
                current = current.left;
            }
        }

        return result;
    }
}
