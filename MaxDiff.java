class Codechef {
    public static void main(String[] args) throws java.lang.Exception {

        int n = 10;
        int m = 89;

        if (gcd(n, m) >= n) {
            System.out.println(n + " " + m);
        } else {

            while (gcd(n, m) < n) {

                if (m % (n + 1) == 0) {
                    n += 1;
                }

                else if ((m - 1) % n == 0) {
                    m -= 1;
                }

                else if (n % 2 == 1 && m % 2 == 0) {
                    n += 1;
                }

                else if (n % 2 == 0 && m % 2 == 1) {
                    m -= 1;
                }

                else {
                    n += 1;
                    m -= 1;
                }

            }

            System.out.println(n + " " + m);

        }

    }

    // Function to return gcd of a and b
    static int gcd(int a, int b) {
        int result = Math.min(a, b); // Find Minimum of a nd b
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result; // return gcd of a nd b
    }
}