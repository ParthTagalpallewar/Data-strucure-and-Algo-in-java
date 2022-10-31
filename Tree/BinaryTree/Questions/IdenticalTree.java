package Tree.BinaryTree.Questions;


import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class IdenticalTree extends BinaryTree{
    public static void main(String[] args) {
        IdenticalTree instance = new IdenticalTree();

        boolean isTreeIdentical = instance.isTreeIdentical(
            instance.binaryTree,
            instance.binaryTree);

        System.out.println("Is Tree Identical " + isTreeIdentical);
    }

    public boolean isTreeIdentical(Node t1, Node t2){
        if(t1 == null && t2 == null) return true;

        return (t1.data == t2.data) && isTreeIdentical(t1.left, t2.left) && isTreeIdentical(t1.right, t2.right);
    }
}
