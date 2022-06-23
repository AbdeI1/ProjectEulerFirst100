import java.util.*;

public class ConsecutivePrimeSum {
  public static int[] primes;
  public static Set<Integer> P;
  public static void main(String[] args) {
    int N = 1_000_000;
    primes = sieve(N).stream().mapToInt(Integer::intValue).toArray();
    P = new HashSet<>(); for(int p : primes) P.add(p);
    int maxP = -1; int maxS = -1;
    for(int i = 0; i < primes.length; i++) {
      int t = primes[i], n = 1;
      while(t < N && i+n < primes.length) {
        if(P.contains(t) && n > maxS){
          maxS = n;
          maxP = t;
        }
        t += primes[i+n];
        n++;
      }
    }
    System.out.println(maxP);
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
