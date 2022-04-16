import java.util.HashMap;
import java.util.Map;

public class PairPain {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 1, 2, 2, 3, 3};

        int com_pairs = findPairs1(arr);
        int pairs = findPairs2(arr);

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

    private static int findPairs2(int[] arr){

        HashMap<Integer, Integer> map = getMap(arr);

        int pairs = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){

            if(entry.getKey() == 1) pairs += one_pairs(arr, map.get(1));

            else pairs += ((entry.getValue() * (entry.getValue()-1))/2);
        }

        return pairs;
        

    }

    private static int one_pairs(int arr[], int one_count){
        int pairs = 0;

        int n = arr.length - 1;
        while (n >= arr.length - one_count) {
            pairs += n;
            n -= 1;
        }

        return pairs;
    }

    private static HashMap<Integer, Integer> getMap(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            
            int num = arr[i];

            if(map.containsKey(num)) map.put(num, map.get(num)+1);

            else map.put(num, 1);

        }

        return map;

    }

    
}
