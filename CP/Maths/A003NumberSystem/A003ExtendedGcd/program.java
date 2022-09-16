package CP.Maths.A003NumberSystem.A003ExtendedGcd;


class program {
    // extended Euclidean Algorithm
    public static GcdTriplet gcdExtended(int a, int b) {
       
        if(b == 0){
            return new GcdTriplet(1, 1, a);
        }

        GcdTriplet temp = gcdExtended(b, a%b);
        int x = temp.y;
        int y = temp.x - (a/b) * temp.y;
        int gcd = temp.gcd;
        return new GcdTriplet(x, y, gcd);
    }

    // Driver Program
    public static void main(String[] args) {
        int a = 10, b = 17;
        GcdTriplet extGcd = gcdExtended(a, b);
        System.out.print("gcd(" + a + ", " + b +") = " + extGcd);

        System.out.println();
        int modeloInverse = moduloInverse(a, b);
        System.out.println("Module inverse " + modeloInverse);
    }

    public static int moduloInverse(int a, int m){
        GcdTriplet gcd = gcdExtended(a, m);
        return gcd.x;
    }

}

class GcdTriplet{
    int x;
    int y;
    int gcd;

    public GcdTriplet(int x, int y, int gcd){
        this.x = x;
        this.y = y;
        this.gcd = gcd;
    }

    @Override
    public String toString(){
        return "(x: "+this.x+", y: " + y + " gcd: "+gcd+")";
    }
}
