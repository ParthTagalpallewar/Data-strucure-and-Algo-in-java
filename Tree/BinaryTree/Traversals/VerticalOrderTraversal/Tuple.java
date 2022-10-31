package Tree.BinaryTree.Traversals.VerticalOrderTraversal;

import Tree.BinaryTree.Node;

public class Tuple {
    int vo;
    int ho;
    Node node;

    public Tuple(Node node, int vo, int ho){
        this.node = node;
        this.vo = vo;
        this.ho = ho;
    }
}
