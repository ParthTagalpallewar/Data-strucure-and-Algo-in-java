package Recursions.Linear;

public class AllPermutation {
    public static void main(String[] args) {
        String str = "123";
        permute(str, 0, str.length()-1, 0);
    }

    public static void permute(String str, int start, int end, int count){

        System.out.println("Arrived " + str + " count " + count + " start " + start);
        if(start == end) System.out.println(str);

        else{
            for(int i = start; i <= end; i++){
                str = swap(str, start, i);
                System.out.println("Swap 1 " + str);
                permute(str, start+1, end, count+1);
                str = swap(str, start, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
