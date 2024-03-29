package Tree.BinaryTree.Questions;

import java.util.*;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class NodesWithKDistance extends BinaryTree {

  public static void main(String[] args) {
    NodesWithKDistance instance = new NodesWithKDistance();

    ArrayList<Integer> answer = instance.nodesAtDistanceK(
      instance.binaryTree,
      2,
      instance.binaryTree.left
    );
    System.out.println(answer);
  }

  public void markParent(Node root, HashMap<Node, Node> parentTrack) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();

        if (curr.left != null) {
          queue.add(curr.left);
          parentTrack.put(curr.left, curr);
        }

        if (curr.right != null) {
          queue.add(curr.right);
          parentTrack.put(curr.right, curr);
        }
      }
    }
  }

  public ArrayList<Integer> nodesAtDistanceK(Node root, int k, Node target) {
    ArrayList<Integer> answer = new ArrayList<Integer>();
    HashMap<Node, Node> parentTracker = new HashMap<Node, Node>();
    markParent(root, parentTracker);
    HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(target);
    visited.put(target, true);
    int level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      if (level == k) break;
      level++;

      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();

        if (curr.left != null && visited.get(curr.left) == null) {
          queue.add(curr.left);
          visited.put(curr.left, true);
        }

        if (curr.right != null && visited.get(curr.right) == null) {
          queue.add(curr.right);
          visited.put(curr.right, true);
        }
        Node parent = parentTracker.get(curr);
        if (parent != null && visited.get(parent) == null) {
          queue.add(parent);
          visited.put(parent, true);
        }
      }
    }

    while (!queue.isEmpty()) {
      answer.add(queue.poll().data);
    }

    return answer;
  }
}