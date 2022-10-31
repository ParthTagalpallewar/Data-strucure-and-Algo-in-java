package Tree.BinaryTree.Views.TopView;

import java.util.*;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class TopView extends BinaryTree{
    public static void main(String[] args) {
        TopView instance = new TopView();

        ArrayList<Integer> list = instance.topView(instance.binaryTree);
        System.out.println(list);
    }

    public ArrayList<Integer> topView(Node root){
        ArrayList<Integer> result = new ArrayList<Integer>();

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Stack<Tuple> stack = new Stack<Tuple>();

        stack.push(new Tuple(root, 0));

        while(!stack.isEmpty()){
            int size = stack.size();

            for(int i=0; i<size; i++){

                Tuple tuple = stack.pop();
                Node node = tuple.node;
                int vo = tuple.vo;

                if(!map.containsKey(vo)){
                    map.put(vo, node.data);
                }

                if(node.left != null) stack.push(new Tuple(node.left, vo-1));
                if(node.right != null) stack.push(new Tuple(node.right, vo+1));

            }
        }

        for(Integer node: map.values()){
            result.add(node);
        }

        return result;
    }
}
