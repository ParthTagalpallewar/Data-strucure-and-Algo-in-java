package Stack;
class StackImplimentation{
    
    private int arr[];
    private int top;
    private int capacity;

    // constructor
    StackImplimentation(int size){
        this.arr = new int[size];
        this.capacity = size;
        this.top = -1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("Stack is full");
            System.exit(1);
        }
        
        arr[++top] = x;
        System.out.println("Inserting "+ x);
    }

    public int pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            System.exit(1);
        }

        return arr[top--];
    }

    public Boolean isEmpty(){
        return top == -1;
    }

    public Boolean isFull(){
        return top == capacity-1;
    }

    public void print(){

        if(isEmpty()){
            System.out.println("Stack is Empty");
            System.exit(1);
        }

        for( int i = 0; i <= top; i++){
            System.out.println("Element at Position " + i + " is " + arr[i]);
        }
    }
}