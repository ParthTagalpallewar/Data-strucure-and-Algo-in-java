package Recursions.Linear;

public class LoopingRecursion {
    public static void main(String[] args) {
        // printNum(10, 1);
        // printMe(5);
        reversePrinting(5);
    }

    public static int printNum(int num, int current){

        System.out.println(current);

        if(num == current){
            return current;
        }

        return printNum(num, current += 1);
        
        
    }

    public static void printMe(int limit){

        if(limit > 0){
            printMe(limit - 1);
            System.out.println(limit);
        }

        return;

    }

    public static void reversePrinting(int limit){

        if(limit == 0){
            return;
        }

        System.out.println(limit);
        reversePrinting(limit-1);
    }
}
