import java.util.*;

class TotientPermutation {
  public static Set<Integer>[] primeFactors;
  public static void main(String[] args) {
    int m = 10_000_000;
    getPrimeFactors(m);
    double minR = 10000; int minN = -1;
    for(int n = 2; n < m; n++) {
      int t = eulersTotient(n);
      double r = (double)n/t;
      if(isPermuation(n, t) && r < minR) {
        minN = n;
        minR = r;
      }
    }
    System.out.println(minN);
  }
  public static boolean isPermuation(int n, int t) {
    int[] count = new int[10];
    for(char c : (n+"").toCharArray()) {
      count[c-'0']++;
    }
    for(char c : (t+"").toCharArray()) {
      count[c-'0']--;
    }
    for(int i : count) {
      if(i != 0) {
        return false;
      }
    }
    return true;
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
