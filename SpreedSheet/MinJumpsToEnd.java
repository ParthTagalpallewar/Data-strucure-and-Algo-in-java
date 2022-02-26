class MinJumpsToEnd{
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        int minJumps = minJumpsToEnd(arr);
        System.out.println("Minimum number of jumps to reach end is " + minJumps);
    }

    public static int minJumpsToEnd(int[] arr){
         
        int curr_idx = 0;
        
        int max_num;
        int max_index;
        int count = 1;
        
        while(curr_idx < arr.length){
            
            int curr_val = arr[curr_idx];
            
            max_num = 0;
            max_index = 0;
            
            if(curr_idx + curr_val >= arr.length){
                count += 1;
                break;
            }
            
            
            for(int i = curr_idx; i < curr_idx + curr_val; i++){
                
                if(arr[i] > max_num){
                    max_num = arr[i];
                    max_index = i;
                  
                    count += 1;
                    
                    System.out.println(max_num);
                }
                
                if(i >= arr.length) break;
                
            }
            
            curr_idx = max_index;
            
        }
        
        return count;
    }
}