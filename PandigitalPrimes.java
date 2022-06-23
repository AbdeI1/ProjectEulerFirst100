import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PandigitalPrimes {
  public static int[] primes;
  public static void main(String[] args) {
    primes = sieve(1_000_000_000).stream().mapToInt(Integer::intValue).toArray();
    int res = -1;
    for(int p : primes)
      if(IntStream.rangeClosed(1, (p+"").length()).boxed().map(i -> i+"").collect(Collectors.joining("")).equals((p+"").chars().sorted().map(c -> c-'0').boxed().map(i -> i+"").collect(Collectors.joining(""))))
        res = p;
    System.out.println(res);
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
