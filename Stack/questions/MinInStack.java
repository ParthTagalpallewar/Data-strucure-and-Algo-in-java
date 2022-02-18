package Stack.questions;

import java.util.Stack;

class MinInStack{

    Stack<Integer> stack;
    int min_element;

    public MinInStack(){
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        
        MinInStack instance = new MinInStack();
        instance.push(10);
        System.out.println(instance.getMin());

        instance.push(1);
        System.out.println(instance.getMin());

        instance.pop();
        System.out.println(instance.getMin());

        instance.pop();
        System.out.println(instance.getMin());
    }

    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            min_element = x;
        }else if(x < min_element){
            stack.push(2 * x - min_element);
            min_element = x;
        }else{
            stack.push(x);
        }
    }

    public int pop(){
        if(stack.isEmpty()) return -1;

        int popped = stack.pop();

        if(popped < min_element){
            min_element = 2 * min_element - popped;
            return  (popped + min_element) / 2;
        }else{
            return popped;
        }
    }
    
    public int getMin(){
        if(stack.isEmpty()) return -1;

        else return min_element;
    }

}