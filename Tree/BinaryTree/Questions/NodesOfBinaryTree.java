package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class NodesOfBinaryTree extends BinaryTree {

  public static void main(String[] args) {
    NodesOfBinaryTree instance = new NodesOfBinaryTree();
    int nodes = instance.countNodes(instance.binaryTree);
    System.out.println(nodes);
  }

  public int countNodes(Node root) {
    if (root == null) return 0;

    int left = countLeftHeight(root);
    int right = countRightHeight(root);

    if (left == right) return (2 << left) - 1;

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  public int countLeftHeight(Node node) {
    int count = 0;

    while (node.left != null) {
      node = node.left;
      count += 1;
    }

    return count;
  }

  public int countRightHeight(Node node) {
    int count = 0;
    while (node.right != null) {
      node = node.right;
      count += 1;
    }
    return count;
  }
}
