package CP.BinarySearch;

class SmallestIndex{

    public static void main(String[] args) {
        
        int[] arr = {3, 4, 5, 0, 1, 2};

         
        int left = 0, right = arr.length-1;
        
        while(left < right){
            
            int mid = (left + right) / 2;
            
            if(arr[mid] > arr[right]){
                left = mid+1;
            }else{
                right = mid;
            }  
        }
        
        System.out.println("Smallest Number "+ arr[left]);


    }

}