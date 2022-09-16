import java.util.HashMap;

public class Question {

  static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  static HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
  static int count = 0;

  public static void main(String[] args) {
    int n = 2;
    int k = 5;
    int mod = 1000000007;

    int soln = solution(n, k, mod);
    System.out.println(soln);

    System.out.println("count = " + count);
  }

  private static int solution(int n, int k, int mod) {
    if (k == 0) {
      if (map.containsKey(n)) {
        return 0;
      } else {
        map.put(n, 0);
        count += 1;
        return n % mod;
      }
    }

    int addition = 0;
    for (int i = 1; i * i <= n; i++) {
      if (n % i != 0) continue;

      int a1 = n * i;

      addition = ((addition % mod) + (solution(a1, k - 1, mod) % mod)) % mod;

      if (n / i == i) continue;

      int a2 = n * (n / i);

      addition = ((addition % mod) + (solution(a2, k - 1, mod) % mod)) % mod;
    }

    return addition % mod;
  }
}
