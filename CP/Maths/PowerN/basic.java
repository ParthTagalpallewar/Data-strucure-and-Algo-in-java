package CP.Maths.PowerN;

public class basic {
    public static void main(String[] args) {
        int diff = 0;
        if(diff != 0 && diff != 1){
        		     System.out.println("abc");
        		 } 

    }

    public static long fastPower(long a, long b){
        int n = 1000000007;
        long result = 1;
        while(b > 0){

            if((b&1) == 1){
                result = (result*a)%n;
            }

            a = (a*a)%n;
            b = b >> 1;

        }

        return result;

    }
}
