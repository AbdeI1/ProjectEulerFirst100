import java.util.*;

class TotientMaximum {
  public static Set<Integer>[] primeFactors;
  public static void main(String[] args) {
    int m = 1_000_000;
    getPrimeFactors(m);
    double maxR = -1; int maxN = -1;
    for(int n = 1; n <= m; n++) {
      int t = eulersTotient(n);
      double r = (double)n/t;
      if(r > maxR) {
        maxN = n;
        maxR = r;
      }
    }
    System.out.println(maxN);
  }
  public static int eulersTotient(int n) {
    Set<Integer> primes = primeFactors[n];
    for(int p : primes) {
      n /= p;
      n *= (p-1);
    }
    return n;
  }
  public static void getPrimeFactors(double x) {
    int n = (int)Math.ceil(x) + 1;
    primeFactors = new Set[n];
    for(int i  = 0; i < n; i++) { primeFactors[i] = new HashSet<>(); }
    for(int i = 2; i < n; i++) {
      if(primeFactors[i].size() > 0){ continue; }
      primeFactors[i].add(i);
      for(int j = 2*i; j < n; j += i) {
        primeFactors[j].add(i);
      }
    }
  }
}
