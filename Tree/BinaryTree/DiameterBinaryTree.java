package Tree.BinaryTree;

public class DiameterBinaryTree extends BinaryTree {
    public static void main(String[] args) {
        DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();
        int diameter = diameterBinaryTree.findDiameterBinaryTree(diameterBinaryTree.binaryTree);
        System.out.println("Diameter is " + diameter);
    }

    public int findDiameterBinaryTree(Node root){
        int[] diameter = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
    }

    public int findDiameter(Node root, int[] diameter){
        if(root == null) return 0;

        int lh = findDiameter(root.left, diameter);
        int rh = findDiameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh+rh);

        return 1 + Math.max(lh, rh);
    }
}
