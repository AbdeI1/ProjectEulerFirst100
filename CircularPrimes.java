import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CircularPrimes {
  public static int[] primes;
  public static Set<Integer> P;
  public static void main(String[] args) {
    primes = sieve(1_000_000).stream().mapToInt(Integer::intValue).toArray();
    P = new HashSet<>(); for(int p : primes) P.add(p);
    int count = 0;
    top:
    for(int p : P) {
      for(int i = 0; i < (p+"").length(); i++)
        if(!P.contains(Integer.parseInt(IntStream.range(i, i + (p+"").length()).map(c -> (p+"").charAt(c%(p+"").length()) - '0').boxed().map(c -> c+"").collect(Collectors.joining("")))))
          continue top;
      count++;
    }
    System.out.println(count);
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
