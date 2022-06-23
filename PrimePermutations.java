import java.util.*;
import java.util.stream.Collectors;

public class PrimePermutations {
  public static int[] primes;
  public static Set<Integer> P;
  public static void main(String[] args) {
    primes = sieve(10_000).stream().mapToInt(Integer::intValue).filter(i -> (i+"").length() == 4).toArray();
    P = new HashSet<>(); for(int p : primes) P.add(p);
    for(int i = 0; i < primes.length; i++) {
      for(int j = i+1; j < primes.length; j++) {
        int p1 = primes[i], p2 = primes[j], p3 = 2*primes[j] - primes[i];
        if(!P.contains(p3)) continue;
        String d = (p1+"").chars().sorted().map(c -> c-'0').boxed().map(c -> c+"").collect(Collectors.joining(""));
        if(!(p2+"").chars().sorted().map(c -> c-'0').boxed().map(c -> c+"").collect(Collectors.joining("")).equals(d) || !(p3+"").chars().sorted().map(c -> c-'0').boxed().map(c -> c+"").collect(Collectors.joining("")).equals(d)) continue;
        String s = p1 + "" + p2 + "" + p3;
        if(s.equals("148748178147")) continue;
        System.out.println(p1 + "" + p2 + "" + p3);
      }
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
}
