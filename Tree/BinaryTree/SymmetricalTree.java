package Tree.BinaryTree;

public class SymmetricalTree extends BinaryTree{
    public static void main(String[] args) {
        SymmetricalTree instance = new SymmetricalTree();

        boolean isSymmetrical = instance.isSymmetrical(instance.binaryTree.left, instance.binaryTree.right);
        String ans = isSymmetrical ? "Symmetrical Binary Tree " : "Non-Symmetrical Binary Tree";
        System.out.println(ans);
        
    }

    public boolean isSymmetrical(Node node1, Node node2){

        if(node1 == null && node2 == null) return true;

        if(node1 == null || node2 == null) return false;

        if(node1.data != node2.data) return false;

        boolean leftSize = isSymmetrical(node1.left, node2.right);
        boolean rightSize = isSymmetrical(node1.right, node2.left);

        if(leftSize == false || rightSize == false) return false;

        return true;


    }
}
