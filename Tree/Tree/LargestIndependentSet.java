//https://practice.geeksforgeeks.org/problems/largest-independent-set-problem/1/?category[]=Tree&category[]=Tree&problemStatus=unsolved&difficulty[]=1&page=1&query=category[]TreeproblemStatusunsolveddifficulty[]1page1category[]Tree
package Tree.Tree;

import Tree.BinaryTree.Node;

class LargestIndependentSet{
    public static void main(String[] args) {
    
        Node rootNode = getTree();

        int largest = LISS(rootNode);

        System.out.println(largest);
        
    }

    public static Node getTree(){
        Node node = new Node(16);

        node.left = new Node(68);
        node.right = new Node(103);

        node.left.right = new Node(97);
        node.left.right.right = new Node(45);

        node.right.left = new Node(16);
        node.right.left.left = new Node(14);
        node.right.left.right = new Node(99);
        
        node.right.right = new Node(14);
        node.right.right.right = new Node(41);

        return node;

    }

    public static int LISS(Node root) {
        if (root == null)
            return 0;

        int count_1 = LISS(root.left) + LISS(root.right);

        int count_2 = 1;

        if (root.left != null)
            count_2 += LISS(root.left.left) + LISS(root.left.right);

        if (root.right != null)
            count_2 += LISS(root.right.left) + LISS(root.right.right);

        return Math.max(count_1, count_2);
    }


}

