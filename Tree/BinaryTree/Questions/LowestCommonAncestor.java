package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class LowestCommonAncestor extends BinaryTree{
    public static void main(String[] args) {
        LowestCommonAncestor instance = new LowestCommonAncestor();
        Node lca = instance.lowestCommonAncestor(instance.binaryTree, instance.binaryTree.left, instance.binaryTree.right);
        System.out.println(lca.data);
        
    }

    public Node lowestCommonAncestor(Node root, Node n1, Node n2){
        // base case
        if(root == null || root == n1 || root== n2){
            return root;
        }

        Node left =  lowestCommonAncestor(root.left, n1, n2);
        Node right = lowestCommonAncestor(root.right, n1, n2);

        // result
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{ // both left and right are not null, we found our result
            return root;
        }
    }
}
