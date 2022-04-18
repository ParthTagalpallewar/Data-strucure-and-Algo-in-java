import java.util.HashMap;

public class PairPain {
    
    public static void main(String[] args) {
        
        int[] arr = { 1, 2, 3, 2, 4, 1, 2, 1, 1};

        int ones = 0;
        int twos = 0;

        for(int num: arr){
            if(num == 1) ones++;

            else if(num == 2) twos++;
        }


        int com_pairs = findPairs1(arr);
        int pairs = findPairs2(arr, ones, twos);

        System.out.println("num of pairs n2 " + com_pairs);
        System.out.println("num of pairs " + pairs);
    }

    

    private static int findPairs1(int[] arr) {
        
        int pairs = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){

                int i_val = arr[i];
                int j_val = arr[j];

                if(i_val + j_val >= i_val * j_val) pairs += 1;

            }
        }

        return pairs;

    }

    private static int findPairs2(int[] arr, int ones, int twos){

        int pairs = 0;
        int ones_count = ones;
        int start = arr.length-1; 

        while(ones_count-- > 0){
            pairs += start--;
        }

        pairs += (twos * (twos - 1) / 2);
       
       
        return pairs;
        

    }

   

  
    
}
