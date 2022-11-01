package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;
import Tree.BinaryTree.Traversals.BinaryTreeIterative;
import java.util.*;

public class SerializeAndDeserialization extends BinaryTree {

  public static void main(String[] args) {
    SerializeAndDeserialization instance = new SerializeAndDeserialization();
    String serializedBinaryTree = instance.serializeBinaryTree(
      instance.binaryTree
    );
    // System.out.println(serializedBinaryTree);

    Node root = instance.deserializeBinaryTree(serializedBinaryTree);

    BinaryTreeIterative bti = new BinaryTreeIterative();

    ArrayList<ArrayList<Integer>> inorder1 = bti.levelOrderTraversal(instance.binaryTree);
    ArrayList<ArrayList<Integer>>  inorder2 = bti.levelOrderTraversal(root);

    System.out.println(String.valueOf(inorder1));
    System.out.println(String.valueOf(inorder2));
  }

  public String serializeBinaryTree(Node root) {
    StringBuilder stringBuilder = new StringBuilder();

    Queue<Node> queue = new LinkedList<Node>();
    stringBuilder.append(root.data + ", ");
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node current = queue.poll();

        // For Left
        if (current.left == null) stringBuilder.append("null, "); else {
          queue.add(current.left);
          stringBuilder.append(current.left.data + ", ");
        }

        // For Right
        if (current.right == null) stringBuilder.append("null, "); else {
          queue.add(current.right);
          stringBuilder.append(current.right.data + ", ");
        }
      }
    }

    return stringBuilder.toString();
  }

  public Node deserializeBinaryTree(String sbt) {
    String[] nodes = sbt.split(", ");
    int current_index = 0;

    Queue<Node> queue = new LinkedList<Node>();

    Node root = new Node(Integer.valueOf(nodes[current_index]));
    queue.add(root);

    current_index += 1;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node current = queue.poll();

        Integer left = (nodes[current_index].equals("null"))
          ? 0
          : Integer.valueOf(nodes[current_index]);

        if (left != 0) {
          current.left = new Node(left);
          queue.add(current.left);
        } else {
          current.left = null;
        }

        current_index += 1;

        Integer right = (nodes[current_index].equals("null"))
          ? 0
          : Integer.valueOf(nodes[current_index]);

        if (right != 0) {
          current.right = new Node(right);
          queue.add(current.right);
        } else {
          current.right = null;
        }
        current_index += 1;
      }
    }

    System.out.println("Completed");

    return root;
  }
}
