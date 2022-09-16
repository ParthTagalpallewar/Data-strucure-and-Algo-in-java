package CP.Maths.A004BinomialCoefficient;

public class A001Basics {
    public static void main(String[] args) {
        int n=4;
        int k=1;

        System.out.println(binomialCoefficient(n, k));
    }

    public static int binomialCoefficient(int n, int k){

        if(k>n) return 0;

        if(n==k || k==0) return 1;

        return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
    }
}
