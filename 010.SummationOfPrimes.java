import java.util.*;

class SummationOfPrimes {
  public static void main(String[] args) {
    int n = 2000000;
    List<Integer> primes = sieve(n);
    System.out.println(primes.stream().mapToLong(Integer::longValue).sum());
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
