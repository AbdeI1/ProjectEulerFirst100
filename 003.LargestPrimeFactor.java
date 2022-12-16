import java.util.*;

class LargestPrimeFactor {
  public static void main(String[] args) {
    long n = 600851475143L;
    List<Integer> primes = sieve(Math.sqrt(n));
    for(int i = primes.size() - 1; i >= 0; i--) {
      long p = primes.get(i);
      if(n % p == 0) {
        System.out.println(p);
        break;
      }
    }
  }
  public static List<Integer> sieve(double x) {
    int n = (int)Math.ceil(x) + 2;
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
