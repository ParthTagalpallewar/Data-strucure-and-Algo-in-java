package Tree.BinaryTree.Questions;

import java.util.*;



import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class RootToNode extends BinaryTree {

  public static void main(String[] args) {
    RootToNode instance = new RootToNode();
    ArrayList<Integer> path = instance.path(instance.binaryTree, 4);
    System.out.println(path);
  }

  public ArrayList<Integer> path(Node root, int x) {
    ArrayList<Integer> path = new ArrayList<Integer>();
    if (root != null) findPath(root, x, path);

    return path;
  }

  public Boolean findPath(Node node, int x, ArrayList<Integer> path) {
    if (node == null) return false;

    path.add(node.data);
    if (node.data == x) return true;

    if (findPath(node.left, x, path) || findPath(node.right, x, path)) {
      return true;
    }

    path.remove(path.size() - 1);

    return false;
  }
}
