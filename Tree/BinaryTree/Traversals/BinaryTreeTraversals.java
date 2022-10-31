package Tree.BinaryTree.Traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.Node;

public class BinaryTreeTraversals extends BinaryTree{

    public void inOrderTraversal(Node node){
        
        if( node == null){
            return; 
        }

        inOrderTraversal(node.left);

        System.out.print(node.data + " -> ");


        inOrderTraversal(node.right);
     
    }

    
    public void preOrderTraversal(Node node){
        if (node == null) {
            return;
        }

        System.out.print(node.data + " -> ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    
    public void postOrderTraversal(Node node){
        
        if( node == null){
            return; 
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);

        System.out.print(node.data+ " -> ");
        
    }

    public List<List<Integer>> levelOrderTraversal(Node node){
        
        if(node == null) return null;

        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> results = new LinkedList<List<Integer>>();

        queue.add(node);

        while(!queue.isEmpty()){

            int level_num = queue.size();

            List<Integer> subList = new LinkedList<Integer>();

            for(int i = 0; i < level_num; i++){
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);

                subList.add(queue.poll().data);
            }

            results.add(subList);
           
        }

        return results;
        

    }

}
