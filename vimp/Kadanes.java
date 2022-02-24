class Kadanes{
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        int sum = maxContiginiousSum(arr);

        System.out.println(sum);
    }

    private static int maxContiginiousSum(int[] arr) {
        
        int max_sum = arr[0];
        int curr_sum = 0;
        int max_single_element = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            
            max_single_element = Math.max(max_single_element, arr[i]);

            max_sum = Math.max(max_sum, curr_sum);

            if(curr_sum + arr[i] < 0){
                curr_sum = 0;
                continue;
            }

            curr_sum += arr[i];
        }

        max_sum = Math.max(max_sum, curr_sum);

        if(max_sum == 0) return max_single_element;

        return max_sum;

    }
}