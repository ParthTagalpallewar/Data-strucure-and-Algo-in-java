package CP.Maths.A004BinomialCoefficient;

//  the binomial coefficient is used to denote the number of possible ways to choose a subset 
//  of objects of a given numerosity from a larger set. 

public class A001Basics {
    public static void main(String[] args) {
        int n=2;
        int k=1;

        System.out.println(binomialCoefficient(n, k));
    }

    public static int binomialCoefficient(int n, int k){

        if(k>n) return 0;

        if(n==k || k==0) return 1;

        return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
    }
}
