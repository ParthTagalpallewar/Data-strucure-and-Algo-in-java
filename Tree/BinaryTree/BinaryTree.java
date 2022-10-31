package Tree.BinaryTree;

import Tree.BinaryTree.Traversals.RecursiveTraversals;

public class BinaryTree {

    public Node binaryTree = null;

    public BinaryTree(){
        System.out.println("Extending Binary Tree Creates call its constructor");
        binaryTree = buildBinaryTree();
    }
    
    public Boolean Search(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        }

        // then recur on left subtree /
        boolean res1 = Search(node.left, data);

        // node found, no need to look further
        if (res1)
            return true;

        // node is not found in left,
        // so recur on right subtree /
        boolean res2 = Search(node.right, data);

        return res2;
    }

    public Node buildBinaryTree() {

        // level 1
        Node rootNode = new Node(1);

        // level 2
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);

        // // level 3
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);

        rootNode.right.left = new Node(6);
        rootNode.right.right = new Node(7);

        // // level 4
        // rootNode.left.left.left = new Node(8);
        // rootNode.left.left.right = new Node(9);

        // rootNode.left.right.left = new Node(10);
        // rootNode.left.right.right = new Node(11);

        // rootNode.right.left.left = new Node(12);
        // rootNode.right.left.right = new Node(13);

        // rootNode.right.right.left = new Node(14);
        // rootNode.right.right.right = new Node(15);
       
        return rootNode;

    }

    public void addNode(Node node, int data){
        if(node == null){
            return;
        }

        if(node.data == data){
            return;
        }
   
        if(node.data > data){
            if(node.left == null){
                node.left = new Node(data);
                return;
            }else{
                addNode(node.left, data);
            }
        }

        if(node.data < data){
            if(node.right == null){
                node.right = new Node(data);
            }else{
                addNode(node.right, data);
            }
        }
   
    }
  
    public void printLeafs(Node node){
        if(node.left != null) printLeafs(node.left);
        
        if(node.right != null) printLeafs(node.right);

        if(node.left == null && node.right == null) System.out.println(node.data);

    }   
    public static void main(String[] args) {
        BinaryTree operations = new BinaryTree();
        RecursiveTraversals traversal = new RecursiveTraversals();

        Node rootNode = operations.buildBinaryTree();
        
        traversal.inOrderTraversal(rootNode);
    }
}



