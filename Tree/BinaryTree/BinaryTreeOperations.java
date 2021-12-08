package Tree.BinaryTree;

public class BinaryTreeOperations {
    
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
        BinaryTreeOperations operations = new BinaryTreeOperations();
        Node rootNode = operations.buildBinaryTree();

        Boolean isNumPresent = operations.Search(rootNode, 3);
        System.out.print(isNumPresent);
    }

    

}


