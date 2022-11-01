package Tree.BinaryTree.Questions.ConstructBinaryTree;

import Tree.BinaryTree.Node;
import Tree.BinaryTree.Traversals.BinaryTreeTraversals;
import java.util.*;

public class InOrderAndPostOrder {

  public static void main(String[] args) {
    int[] in_order = { 4, 2, 5, 1, 6, 3, 7 };
    int[] pre_order = {4, 5, 2, 6, 7, 3, 1 };

    InOrderAndPostOrder instance = new InOrderAndPostOrder();
    Node root = instance.buildTree(in_order, pre_order);

    BinaryTreeTraversals traversals = new BinaryTreeTraversals();
    traversals.inOrderTraversal(root);
    
  }

  public Node buildTree(int[] inOrder, int[] postOrder){

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int n = inOrder.length;

    for(int i=0; i<n; i++){
      map.put(inOrder[i], i);
    }

    Node root = buildTree(inOrder, 0, n-1, postOrder, 0, n-1, map);
    return root;

  }

  private Node buildTree(int[] inOrder, int in_start, int in_end, int[] postOrder, int post_start, int post_end, HashMap<Integer, Integer> map) {

    if(in_start > in_end || post_start > post_end) return null;

    Node current = new Node(postOrder[post_end]);
    int root_index_inOrder = map.get(current.data);
    int left_nodes = root_index_inOrder - in_start;
    int right_nodes = in_end - root_index_inOrder;

    current.left = buildTree(inOrder, in_start, root_index_inOrder-1, postOrder, post_start, post_start+left_nodes-1, map);
    current.right = buildTree(inOrder, root_index_inOrder+1, in_end, postOrder, post_start+right_nodes, post_end-1  , map);
    
    return current;
  }
}
