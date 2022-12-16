import java.util.*;

class DistinctPrimeFactors {
  public static void main(String[] args) {
    int d = 1_000_000;
    Set<Integer>[] primeFactors = getPrimeFactors(d);
    for(int i = 0;; i++) {
      Set<Integer> allFactors = new HashSet<>();
      for(int j = 0; j < 4; j++) {
        if(primeFactors[i+j].size() != 4) continue;
        allFactors.addAll(primeFactors[i+j]);
      }
      if(allFactors.size() >= 16) {
        System.out.println(i);
        break;
      }
    }
  }
  public static Set<Integer>[] getPrimeFactors(double x) {
    int n = (int)Math.ceil(x) + 1;
    Set<Integer>[] primeFactors = new Set[n];
    for(int i  = 0; i < n; i++) { primeFactors[i] = new HashSet<>(); }
    for(int i = 2; i < n; i++) {
      if(primeFactors[i].size() > 0){ continue; }
      primeFactors[i].add(i);
      for(int j = 2*i; j < n; j += i) {
        int s = 1; int c = j;
        while(c%i == 0) {
          s *= i;
          c /= i;
        }
        primeFactors[j].add(s);
      }
    }
    return primeFactors;
  }
}
