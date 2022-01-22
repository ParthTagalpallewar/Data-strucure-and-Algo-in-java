package Recursions.TreeRecursion;

public class tree {
    public static void main(String[] args) {
        recursion(3);
    }

    public static void recursion(int n) {

        if(n == 0) return;

        System.out.println(" per " + n);
        recursion(n-1);

        System.out.println("IN " + n);
        recursion(n-1);
        
        System.out.println("Post " + n);
    }
}
