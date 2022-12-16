import java.util.*;

class QuadraticPrimes {
  public static int[] primes;
  public static Set<Long> P;
  public static void main(String[] args) {
    primes = sieve(100_000_000).stream().mapToInt(Integer::intValue).toArray();
    P = new HashSet<>(); for(int p : primes) P.add((long)p);
    int max = -1; int maxP = -1;
    for(int a = -999; a < 1000; a++){
      for(int b = -1000; b <= 1000; b++) {
        int h = howMany(a, b);
        if(h > max) {
          max = h;
          maxP = a*b;
        }
      }
    }
    System.out.println(maxP);
  }
  public static int howMany(int a, int b) {
    for(int i = 0;; i++)
      if(!P.contains((long)(i*i + a*i + b))) return i;
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
}
