package TwoPointer;

class Shift1and0 {
    public static void main(String[] args) {
        char[] chars = "101010".toCharArray();

        String rearrange = rearrange_1(chars);

        System.out.println(rearrange);

    }

   
    private static String rearrange_1(char[] chars) {

        int low = 0;
        int high = chars.length - 1;


        for (int i = 0; i < chars.length; i += 1) {

            if(low >= high) break;

            if (chars[low] == '1') {
                swap(chars, low, i);
                low += 1;
            } else {
                swap(chars, high, i);
                high -= 1;
                i -= 1;
            }
            
            
        }

        return String.valueOf(chars);

    }

    private static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}