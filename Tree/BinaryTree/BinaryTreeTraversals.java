package Tree.BinaryTree;
public class BinaryTreeTraversals {

    public void postOrderTraversal(Node node){
        
        if( node == null){
            return; 
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);

        System.out.print(node.data+ " -> ");
        
    }

    public void preOrderTraversal(Node node){
        if (node == null) {
            return;
        }

        System.out.print(node.data + " -> ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(Node node){
        
        if( node == null){
            return; 
        }

        inOrderTraversal(node.left);

        System.out.print(node.data + " -> ");

        inOrderTraversal(node.right);
     
    }

    public Node buildBinaryTree(){

        Node rootNode = new Node(10);

        rootNode.left = new Node(5);
        rootNode.right = new Node(15);

        rootNode.left.left = new Node(1);
        rootNode.left.right = new Node(9);

        rootNode.right.left = new Node(11);
        rootNode.right.right = new Node(19);

        return rootNode;

    }

    public static void main(String[] args) {
        
        BinaryTreeTraversals treeTraversals = new BinaryTreeTraversals();
        Node rootNode = treeTraversals.buildBinaryTree();

        treeTraversals.postOrderTraversal(rootNode);
        System.out.println(" ");
        treeTraversals.preOrderTraversal(rootNode);
        System.out.println(" ");
        treeTraversals.inOrderTraversal(rootNode);
    }
}
