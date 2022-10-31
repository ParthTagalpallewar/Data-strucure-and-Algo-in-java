package Tree.BinaryTree.Questions.WidthOfBinayTree;

import java.util.LinkedList;
import java.util.Queue;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class WidthOfBinaryTree extends BinaryTree {
    public static void main(String[] args) {
        
        WidthOfBinaryTree instance = new WidthOfBinaryTree();
        int width = instance.widthOfBinaryTree(instance.binaryTree);
        System.out.println("Width is " + width);
    }

    public int widthOfBinaryTree(Node root){

        if(root == null) return 0;
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, root));


        int width = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int mmin = queue.peek().index;
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                int index = curr.index-mmin;

                if(curr.node.left != null){
                    queue.add(new Pair(2*index+1, curr.node.left));
                }

                if(curr.node.right != null){
                    queue.add(new Pair(2*index+2, curr.node.right));
                }

                if(i == 0) first = index;

                if(i == size-1) last = index;


            }
        
            width = Math.max(width, last-first+1);

        }
        return width;
    }
}
