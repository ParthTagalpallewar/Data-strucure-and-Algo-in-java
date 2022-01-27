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

        int arr[] = {5, 15, 19, 25};
    

        for(int i = 0; i< arr.length; i++){
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
  
    public int countHeight(Node node){

        if(node.left != null) return 1 + countHeight(node.left);
       
        if(node.right != null) return 1 + countHeight(node.right);

        return 1; 
    }

    public static void main(String[] args) {
        BinaryTreeOperations operations = new BinaryTreeOperations();
        BinaryTreeTraversals traversal = new BinaryTreeTraversals();

        Node rootNode = operations.buildBinaryTree();
        
        traversal.inOrderTraversal(rootNode);

        int height =  operations.countHeight(rootNode);
        System.out.println();
        System.out.println(height);
    }



}


