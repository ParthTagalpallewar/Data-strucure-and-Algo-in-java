package Tree.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class BalanceSubTree extends BinaryTree{
    public static void main(String[] args) {
        
        BalanceSubTree bst = new BalanceSubTree();

        BinaryTreeTraversals traversals = new BinaryTreeTraversals();
        List<List<Integer>> levelOrder = traversals.levelOrderTraversal(bst.binaryTree);
        System.out.println(levelOrder);

        int diff = bst.isBalanceTree(bst.binaryTree);
        System.out.println("Binary Tree Diff " + diff);
        String isBalance = (bst.isBalanceTree(bst.binaryTree) != -1) ? "Balance" : "Unbalance";
            
        System.out.println(isBalance);

    }
    // At each step check if it is unbalance return -1
    // always return height of current node (max of node->left and node-right)
    private int isBalanceTree(Node node){

        if(node == null) return 0;
        
        int lt = isBalanceTree(node.left);
        if(lt == -1) return -1;
        
        int rt = isBalanceTree(node.right);
        if(rt == -1) return -1;
        
        if(Math.abs(lt-rt) > 1) return -1;

        return Math.max(lt, rt)+1;
    }

    
}
