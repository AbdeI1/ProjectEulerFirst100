import java.util.*;

public class CountingFractions {
  public static void main(String[] args) {
    int d = 1_000_000;
    Set<Integer>[] primeFactors = getPrimeFactors(d);
    long count = 0;
    for(int i = 2; i <= d; i++) {
      count += eulersTotient(i, primeFactors[i]);
    }
    System.out.println(count);
  }
  public static int eulersTotient(int n, Set<Integer> primeFactors) {
    for(int p : primeFactors) {
      n /= p;
      n *= (p-1);
    }
    return n;
  }
  public static Set<Integer>[] getPrimeFactors(double x) {
    int n = (int)Math.ceil(x) + 1;
    Set<Integer>[] primeFactors = new Set[n];
    for(int i  = 0; i < n; i++) { primeFactors[i] = new HashSet<>(); }
    for(int i = 2; i < n; i++) {
      if(primeFactors[i].size() > 0){ continue; }
      primeFactors[i].add(i);
      for(int j = 2*i; j < n; j += i) {
        primeFactors[j].add(i);
      }
    }
    return primeFactors;
  }
}
