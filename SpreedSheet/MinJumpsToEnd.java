class MinJumpsToEnd{
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 7};
        //  int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        //  int[] arr = {1, 4, 3, 2, 6, 7};

        int minJumps = minJumpsToEnd(arr);
        System.out.println("Minimum number of jumps to reach end is " + minJumps);
    }

    public static int minJumpsToEnd(int[] arr){
       
        int minJumps = 0;
        int currentIndex = 0;

        while(currentIndex < arr.length-1){
            
            int maxJumps = arr[currentIndex];

            if(currentIndex + maxJumps >= arr.length-1){
                minJumps += 1;
                break;
            }

            int nextJump = getCurrentJump(arr, currentIndex);

            if(nextJump == -1) return -1;

            minJumps += 1;
            currentIndex = nextJump;


        }

        return minJumps;
       
    }

    public static int getCurrentJump(int[] arr, int currentIndex){
        int maxJumps = arr[currentIndex];

        int nextJump = 0;
        int nextJumpIndex = 0;


        for(int i = currentIndex + 1; i <= currentIndex + maxJumps; i++){
            if(arr[i] != 0 && arr[i] + i >= nextJump) {
                nextJump = arr[i] + i;
                nextJumpIndex = i;
            }

            // System.out.println(arr[i]);
        }

        // System.out.println();

        return (nextJumpIndex == 0) ? -1 : nextJumpIndex;
    }

    
}