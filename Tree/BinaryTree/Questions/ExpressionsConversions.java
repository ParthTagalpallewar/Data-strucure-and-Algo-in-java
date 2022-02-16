package Tree.BinaryTree.Questions;

import java.util.Stack;

import Tree.BinaryTree.Questions.ExpressionConverssions.ExpressionNode;



public class ExpressionsConversions {


    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            return true;
        }
        return false;
    }

    public static ExpressionNode expressionTree(String postfix) {
        Stack<ExpressionNode> st = new Stack<ExpressionNode>();
        ExpressionNode t1, t2, temp;

        for (int i = 0; i < postfix.length(); i++) {
            if (!isOperator(postfix.charAt(i))) {
                temp = new ExpressionNode(postfix.charAt(i));
                st.push(temp);
            } else {
                temp = new ExpressionNode(postfix.charAt(i));

                t1 = st.pop();
                t2 = st.pop();

                temp.left = t2;
                temp.right = t1;

                st.push(temp);
            }

        }
        temp = st.pop();
        return temp;
    }

    public static void inorder(ExpressionNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        String postfix = "231*+9-"    ;

        ExpressionNode r = expressionTree(postfix);
        inorder(r);
    }

}
