import java.util.*;

class PrimePowerTriples {
  public static void main(String[] args) {
    int n = 50_000_000;
    List<Integer> primes = sieve(n);
    int[] primes2 = primes.stream().filter(p -> p < Math.sqrt(n)).mapToInt(p -> p*p).toArray();
    int[] primes3 = primes.stream().filter(p -> p < Math.pow(n, (1./3.))).mapToInt(p -> p*p*p).toArray();
    int[] primes4 = primes.stream().filter(p -> p < Math.pow(n, (1./4.))).mapToInt(p -> p*p*p*p).toArray();
    Set<Integer> nums = new HashSet<>();
    for(int p2 : primes2) {
      for(int p3 : primes3) {
        for(int p4 : primes4) {
          if(p2 + p3 + p4 < n) {
            nums.add(p2 + p3 + p4);
          }
        }
      }
    }
    System.out.println(nums.size());
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
