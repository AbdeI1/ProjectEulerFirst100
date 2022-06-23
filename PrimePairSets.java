import java.util.*;

public class PrimePairSets {
  public static int[] primes;
  public static Set<Long> P;
  public static Map<Integer, Set<Integer>> M;
  public static void main(String[] args) {
    primes = sieve(100_000_000).stream().mapToInt(Integer::intValue).toArray();
    P = new HashSet<>(); for(int p : primes) P.add((long)p);
    M = new HashMap<>();
    int N = 10_000;
    for(int i = 0; primes[i] < N; i++) {
      for(int j = 0; primes[j] < N; j++) {
        if(i==j){ continue; }
        if(works(new int[]{primes[i], primes[j]})) {
          if(M.containsKey(primes[i])) { M.get(primes[i]).add(primes[j]); }
          else { M.put(primes[i], new HashSet<Integer>(primes[j])); }
          if(M.containsKey(primes[j])) { M.get(primes[j]).add(primes[i]); }
          else { M.put(primes[j], new HashSet<Integer>(primes[i])); }
        }
      }
    }
    Set<Integer> cur = new HashSet<>();
    for(int x : M.keySet()) {
      if(M.get(x).size() < 4) { continue; }
      cur.add(x);
      recurse(cur);
      cur.remove(x);
    }
  }
  public static void recurse(Set<Integer> cur) {
    if(cur.size() >= 5) {
      System.out.println(cur.stream().mapToInt(Integer::intValue).sum());
      System.exit(0);
    }
    int x = cur.stream().mapToInt(Integer::intValue).reduce(-1, Integer::max);
    int[] c = cur.stream().mapToInt(Integer::intValue).toArray();
    top:
    for(int y : M.get(x)) {
      if(cur.contains(y)) { continue; }
      for(int z : c) {
        if(!M.get(z).contains(y)) {
          continue top;
        }
      }
      cur.add(y);
      recurse(cur);
      cur.remove(y);
    }
  }
  public static boolean works(int[] p) {
    for(int i = 0; i < p.length; i++) {
      for(int j = 0; j < p.length; j++) {
        if(i == j) { continue; }
        long x = Long.parseLong("" + p[i] + "" + p[j]);
        if(!P.contains(x)) {
          return false;
        }
      }
    }
    return true;
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
