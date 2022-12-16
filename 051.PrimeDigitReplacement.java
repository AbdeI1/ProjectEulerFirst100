import java.util.*;

class PrimeDigitReplacement {
  public static int[] primes;
  public static Set<Long> P;
  public static void main(String[] args) {
    primes = sieve(1000_000).stream().mapToInt(Integer::intValue).toArray();
    P = new HashSet<>(); for(int p : primes) P.add((long)p);
    for (int prime : primes) {
      if(works(prime)) {
        break;
      }
    }
  }
  public static boolean works(int p) {
    int l = 1 << ((p+"").length());
    for(int i = 1; i < l; i++) {
      Set<Long> d = check(p, i);
      if(d.size() >= 8 && d.contains(Long.parseLong(p + ""))) {
        System.out.println(d.stream().mapToLong(Long::longValue).reduce(100_000_000L, Long::min));
        return true;
      }
    }
    return false;
  }
  public static Set<Long> check(int p, int b) {
    String s1 = p+"";
    int l = s1.length();
    Set<Long> count = new HashSet<>();
    for(int i = 0; i < 10; i++) {
      StringBuilder s2 = new StringBuilder();
      for(int j = 0; j < s1.length(); j++) {
        if(((b >> (l-j-1)) & 1) == 1){
          s2.append(i);
        } else {
          s2.append(s1.charAt(j));
        }
      }
      if(s2.charAt(0) == '0') { continue; }
      if(P.contains(Long.parseLong(s2.toString()))) {
        count.add(Long.parseLong(s2.toString()));
      }
    }
    return count;
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
