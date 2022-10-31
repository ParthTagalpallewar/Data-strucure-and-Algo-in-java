package Tree.BinaryTree;

import java.util.*;

public class MinTimeToBurnBinaryTree extends BinaryTree{
    public static void main(String[] args) {
        MinTimeToBurnBinaryTree instance = new MinTimeToBurnBinaryTree();

        int answer = instance.minTimeToBurnBinaryTree(instance.binaryTree, instance.binaryTree.left.left);
        System.out.println(answer);
        
    }

    public void markParent(Node root, HashMap<Node, Node> parentTrack){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size; i++){
                Node curr = queue.poll();

                if(curr.left != null){
                    queue.add(curr.left);
                    parentTrack.put(curr.left, curr);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                    parentTrack.put(curr.right, curr);
                }
            }
        }
    }

    public int minTimeToBurnBinaryTree(Node root, Node target){
        int minTime = -1;
        HashMap<Node, Node> parentTracker = new HashMap<Node, Node>();
        markParent(root, parentTracker);
        HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>(); 
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(target);
        visited.put(target, true);

        while(!queue.isEmpty()){
            int size = queue.size();

            minTime+=1;
            
            for(int i=0; i<size; i++){
                Node curr = queue.poll();

                if(curr.left != null && visited.get(curr.left)==null){
                    queue.add(curr.left);
                    visited.put(curr.left, true);
                }

                if(curr.right != null && visited.get(curr.right)==null){
                    queue.add(curr.right);
                    visited.put(curr.right, true);
                }
                Node parent = parentTracker.get(curr);
                if(parent != null && visited.get(parent) == null){
                    queue.add(parent);
                    visited.put(parent, true);
                }

            }
        }

        return minTime;
    }
}
