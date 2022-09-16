class ABC{
    public static void main(String[] args) {
        int n = 46341;

        System.out.println(seriesSum(n));
        System.out.println(seriesSum1(n));
    }

    static long seriesSum(int n) {
        long ans = (long) (n * (n+1))/2;
        return ans;
    }

    static long seriesSum1(int n) {
       
       long a = n;
       return a*(a+1)/2;
      
   }
}