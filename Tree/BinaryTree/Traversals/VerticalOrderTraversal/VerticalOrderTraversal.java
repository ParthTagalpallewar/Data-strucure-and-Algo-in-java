package Tree.BinaryTree.Traversals.VerticalOrderTraversal;

import java.util.*;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class VerticalOrderTraversal extends BinaryTree{
    public static void main(String[] args) {
        VerticalOrderTraversal instance = new VerticalOrderTraversal();

        ArrayList<ArrayList<Integer>> verticalOrder = instance.verticalOrderTraversal(instance.binaryTree);

        System.out.println(verticalOrder);

    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();
        Queue<Tuple> queue = new LinkedList<Tuple>();

        queue.add(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Tuple tuple = queue.poll();
                Node node = tuple.node;
                int vo = tuple.vo;
                int ho = tuple.ho;

                if(!map.containsKey(vo)){
                    map.put(vo, new TreeMap<>());
                }

                if(!map.get(vo).containsKey(ho)){
                    map.get(vo).put(ho, new PriorityQueue<>());
                }

                map.get(vo).get(ho).add(node.data);

                if(node.left != null){
                    queue.add(new Tuple(node.left, vo-1, ho+1));
                }
                if(node.right != null){
                    queue.add(new Tuple(node.right, vo+1, ho+1));
                }   
            }  
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){

            ArrayList<Integer> inner = new ArrayList<Integer>();

            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    inner.add(nodes.poll());
                }

            }

            result.add(inner);

        }

        return result;
    }
}
