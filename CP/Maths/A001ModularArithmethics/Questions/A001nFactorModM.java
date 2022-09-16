package CP.Maths.A001ModularArithmethics.Questions;

class A001nFactorModM {
    // Method 1
    // Returns value of n! % p
    static int modFact(int n, int p) {
        if (n >= p)
            return 0;

        int result = 1;
        for (int i = 1; i <= n; i++)
            result = (result * i) % p;

        return result;
    }

    //Method 2
    
    public static void main(String[] args) {
        int n = 31, p = 29;
        System.out.print(modFact(n, p));
    }
}

