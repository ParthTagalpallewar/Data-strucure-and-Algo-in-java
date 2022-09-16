class Triplets{
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        printTriplet(arr);
        
    }

    public static void printTriplet(int[] arr){

        int ans = 0;

        int l = 0;
        int r = 2;
        int n = arr.length;
        
        int sum = (arr[0] + arr[1] + arr[2])/3; 
        ans = sum;

        while(r < n-1){
            sum -= arr[l++];
            sum += arr[++r];

            ans += sum/3;
        }
        
        System.out.println(ans);
    }

    

}

