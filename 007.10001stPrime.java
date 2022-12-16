import java.util.ArrayList;
import java.util.List;

class TenThousandFirstPrime {
  public static void main(String[] args) {
    List<Integer> primes = sieve(1000000);
    System.out.println(primes.get(10000));
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
