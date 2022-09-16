package CP.Maths.A002ModularExponentiation;

public class BinaryExponentiation {
    public static void main(String[] args) {
        long ans = recursiveBinaryExponentiation(10, 100000);
        System.out.println(ans);

        long ans2 = iterativeBinaryExponentiation(10, 100000);
        System.out.println(ans2);
    }

    public static long recursiveBinaryExponentiation(int base, int power){
        long mod = 1000000007l;

        if(power == 0) return 1;

        if(power == 1) return base;

        long t = recursiveBinaryExponentiation(base, power/2);
        long result = ((t%mod)*(t%mod))%mod;

        if((power&1) == 1) result = (result*base)%mod;
        
        return result;
    }

    public static long iterativeBinaryExponentiation(long base, long power){
        long mod = 1000000007;

        long result = 1;

        while(power > 0){
            if((power&1)==1) result = (result*base)%mod;
            base = ((base%mod)*(base%mod))%mod;
            power >>= 1;
        }

        return result;
    }
}
