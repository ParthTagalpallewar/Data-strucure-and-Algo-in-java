package Bitwise.Questions;

public class A006MaximumAnd {
    public static void main(String[] args) {
        
        int[] arr = {4, 8, 12, 16};

        int max = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(i == j) continue;
                max = Math.max(max, arr[i]&arr[j]);
            }
        }
        System.out.println(max);

    }
}
