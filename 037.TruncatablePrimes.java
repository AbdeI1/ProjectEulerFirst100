import java.util.*;
import java.util.stream.IntStream;

class TruncatablePrimes {
  public static int[] primes;
  public static Set<Long> P;
  public static void main(String[] args) {
    primes = sieve(100_000_000).stream().mapToInt(Integer::intValue).toArray();
    P = new HashSet<>(); for(int p : primes) P.add((long)p);
    List<Integer> found = new ArrayList<>();
    for(int i  = 4; found.size() < 11; i++) {
      int finalI = i;
      if(IntStream.range(0, (primes[i] + "").length()).boxed().map((primes[i] + "")::substring).allMatch(o -> P.contains(Long.parseLong(o))) && IntStream.range(1, (primes[i]+"").length() + 1).boxed().map(o -> (primes[finalI]+"").substring(0, o)).allMatch(o -> P.contains(Long.parseLong(o))))
        found.add(primes[i]);
    }
    System.out.println(found.stream().mapToInt(Integer::intValue).sum());
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
