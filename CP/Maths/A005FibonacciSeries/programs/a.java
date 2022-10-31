package CP.Maths.A005FibonacciSeries.programs;


public class a {
        public static void main(String[] args) {
        final expo ex = new expo();
        for (int i = 0; i < 10; i++) {
            System.out.println("f(" + i + ") = " + ex.fibo(i));
        }


    }
}

class expo{
    
    long[][][] exponents;

    public expo(){
        exponents = new long[64][2][2];
        exponents[0] = new long[][]{{1, 1}, {1, 0}};

        for(int i=1; i < exponents.length; i++){
            exponents[i] = square(exponents[i-1]);
        }
    }

    public long[][] square(long[][] arr){
        return multiply(arr, arr);
    }

    public long[][] multiply(long[][] arr1, long[][] arr2){

        long[][] result = new long[arr1.length][arr2[0].length];

        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                for(int k=0; k < result.length; k++){
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;

    }
    
    public long fibo(int n){
        if(n < 0) return -1;

        else if(n < 2) return n;

        else{
            final long[][] matrix = binaryExponentiation(n - 2);
            return matrix[0][0] + matrix[0][1];
        }
    }

    private long[][] binaryExponentiation(int n) {
       long[][] ans = new long[][]{{1, 0}, {0, 1}};

       for(int i=31; i >= 0; i--){
            if((n & (1<<i)) != 0){
                ans = multiply(ans, exponents[i]);
            }
       }

       return ans;
    }
}



