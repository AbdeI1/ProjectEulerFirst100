import java.io.*;
import java.util.*;

public class AmicableChains {
  public static void main(String[] args) {
    boolean[] hit = new boolean[1000001];
    int ans = 1000001;
    int longestChain = -1;
    for(int i = 0; i < 1000001; i++) {
      if(hit[i]) { continue; }
      hit[i] = true;
      Set<Integer> divisors = getDivisors(i);
      Set<Integer> v = new HashSet<>();
      v.add(i);
      int s = divisors.stream().mapToInt(Integer::intValue).sum();
      while(s < 1000001 && !hit[s]) {
        hit[s] = true;
        v.add(s);
        s = getDivisors(s).stream().mapToInt(Integer::intValue).sum();
      }
      if(v.contains(s)) {
        int count = 1;
        int min = s;
        int st = getDivisors(s).stream().mapToInt(Integer::intValue).sum();;
        while(st != s) {
          count++;
          st = getDivisors(st).stream().mapToInt(Integer::intValue).sum();
          min = Math.min(min, st);
        }
        if(count > longestChain) {
          longestChain = count;
          ans = min;
        }
      }
    }
    System.out.println(ans);
  }
  public static Set<Integer> getDivisors(int n) {
    Set<Integer> divs = new HashSet<>();
    divs.add(1);
    for(int i = 2; i*i <= n; i++) {
      if(n%i == 0) {
        divs.add(i);
        divs.add(n/i);
      }
    }
    return divs;
  }
}
