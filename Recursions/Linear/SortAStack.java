package Recursions.Linear;

import java.util.*;

public class SortAStack {
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        for(int i = 10; i > 0; i--) {
            s.push(i);
        }

        sort(s);

        System.out.println(s);
    }

    private static void sort(Stack<Integer> s) {
        
        if(s.isEmpty()) return;

        int popped = s.pop();
        sort(s);

        insert(s, popped);
    }

    private static void insert(Stack<Integer> s, int x) {
        
        if(s.isEmpty() || s.peek() < x){
            s.push(x);
            return;
        }

        int popped = s.pop();
        insert(s, x);
        s.push(popped);
    }

}
