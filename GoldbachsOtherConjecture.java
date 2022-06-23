import java.util.*;

public class GoldbachsOtherConjecture {
  public static int[] primes;
  public static void main(String[] args) {
    primes = sieve(10_000).stream().mapToInt(Integer::intValue).toArray();
    int pi = 1;
    top:
    for(int i = 3;; i += 2){
      if(primes[pi] == i) {
        pi++;
        continue;
      }
      for(int j = pi; j >= 0; j--)
        if (isPerfectSquare((i - primes[j]) / 2))
          continue top;
      System.out.println(i);
      break;
    }
  }
  public static List<Integer> sieve(double x) {
    int n = (int)Math.ceil(x) + 1;
    boolean[] isNotPrime = new boolean[n];
    List<Integer> primes = new ArrayList<>();
    for(int i = 2; i < n; i++) {
      if(isNotPrime[i]){ continue; }
      primes.add(i);
      for(int j = 2*i; j < n; j += i) {
        isNotPrime[j] = true;
      }
    }
    return primes;
  }
  public static boolean isPerfectSquare(long sq) {
    long h = (long)Math.ceil(Math.sqrt(sq)) + 1;
    long l = (long)Math.floor(Math.sqrt(sq)) - 1;
    for(long n = l; n <= h; n++) if(n*n == sq) return true;
    return false;
  }
}
