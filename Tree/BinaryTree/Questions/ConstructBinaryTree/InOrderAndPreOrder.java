package Tree.BinaryTree.Questions.ConstructBinaryTree;

import Tree.BinaryTree.Node;
import Tree.BinaryTree.Traversals.BinaryTreeTraversals;
import java.util.*;

public class InOrderAndPreOrder {

  public static void main(String[] args) {
    int[] in_order = { 4, 2, 5, 1, 6, 3, 7 };
    int[] pre_order = { 1, 2, 4, 5, 3, 6, 7 };

    InOrderAndPreOrder instance = new InOrderAndPreOrder();
    Node root = instance.buildTree(in_order, pre_order);

    BinaryTreeTraversals traversals = new BinaryTreeTraversals();
    traversals.inOrderTraversal(root);
    
  }

  public Node buildTree(int[] inOrder, int[] preOrder){
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int n = inOrder.length;

    for (int i = 0; i < n; i++) {
        map.put(inOrder[i], i);
    }

    Node root = buildTree(preOrder, 0, n-1, inOrder, 0, n-1, map);
    return root;

  }

  public Node buildTree(int[] preOrder, int pre_start, int pre_end, int[] inOrder, int in_start, int in_end, HashMap<Integer, Integer> map){

        if(pre_start > pre_end || in_start > in_end) return null;

        Node curr = new Node(preOrder[pre_start]);
        int root_index_inOrder = map.get(curr.data);
        int left_nodes = root_index_inOrder - in_start;

        curr.left = buildTree(preOrder, pre_start+1, pre_start+left_nodes, inOrder, in_start, root_index_inOrder-1, map);

        curr.right = buildTree(preOrder, pre_start+left_nodes+1, pre_end, inOrder, root_index_inOrder+1, in_end, map);
    
        return curr;
    }
}
