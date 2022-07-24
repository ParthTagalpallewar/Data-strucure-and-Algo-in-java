import java.lang.Math;

public class ABC {
    public static void main(String[] args) {
        int n = 99;

        System.out.println("Approach1 " + approach1(n));
        System.out.println("Approach2 " + approach2(n));
        System.out.println("Approach3 " + approach3(n));

    }

    public static int approach1(int n){
        
        return (n+1)/2;


    }
    public static int approach2(int n){
        
        if(n%2 == 1){
            return (n/2)+1;
        }else{
            return (n/2);
        }


    }

    public static int approach3(int n){
        return (int) Math.ceil(n/2);
    }

}
