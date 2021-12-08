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

        int arr[] = new int[5];
        arr[0] = 5;
        arr[1] = 11;
        arr[2] = 1;
        arr[3] = 9;
        arr[4] = 19;

        for(int i = 0; i<5; i++){
            addNode(rootNode, arr[i]);
        }
       
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
    public static void main(String[] args) {
        BinaryTreeOperations operations = new BinaryTreeOperations();
        BinaryTreeTraversals traversal = new BinaryTreeTraversals();

        Node rootNode = operations.buildBinaryTree();

        Boolean isNumPresent = operations.Search(rootNode, 3);
        System.out.println(isNumPresent);

        operations.addNode(rootNode, 3);

        isNumPresent = operations.Search(rootNode, 3);
        System.out.println(isNumPresent);
        
        traversal.inOrderTraversal(rootNode);

    }



}


