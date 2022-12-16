import java.util.*;

class PrimeSummations {
  public static int[] primes;
  public static Set<List<Integer>>[] dp;
  public static void main(String[] args) {
    primes = sieve(10000).stream().mapToInt(Integer::intValue).toArray();
    dp = new HashSet[1000];
    dp[0] = new HashSet<>(); dp[1] = new HashSet<>();
    int n = 5000;
    int cur = 64; int step = cur/2;
    while(step > 0) {
      int c = count(cur).size();
      if(c > 5000) { cur -= step; }
      else { cur += step; }
      step /= 2;
    }
    System.out.println(cur);
  }
  public static Set<List<Integer>> count(int x) {
    if(x <= 1) { return new HashSet<>(); }
    if(dp[x] != null) { return dp[x]; }
    Set<List<Integer>> res = new HashSet<>();
    for(int i = 0; primes[i] <= x; i++) {
      if(primes[i] == x) {
        List<Integer> p = new ArrayList<>();
        p.add(x);
        res.add(p);
        continue;
      }
      Set<List<Integer>>  l = count(x-primes[i]);
      if(l.size() > 0) {
        for(List<Integer> s : l) {
          List<Integer> a = new ArrayList<>(s);
          a.add(primes[i]);
          Collections.sort(a);
          res.add(a);
        }
      }
    }
    dp[x] = res;
    return res;
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
