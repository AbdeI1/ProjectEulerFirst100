import java.io.*;
import java.util.*;

class ProductSumNumbers {
  public static void main(String[] args) {
    int[] min = new int[12001];
    int count = 0;
    for(int i = 1; i <= min.length*2; i++) {
      if(count >= 12000) { break; }
      List<List<Integer>> factorings = getDivisorsList(2, i);
      List<Integer> ex = new ArrayList<>();
      ex.add(i);
      factorings.add(ex);
      for(List<Integer> fac : factorings) {
        int k = i - fac.stream().mapToInt(Integer::intValue).sum() + fac.size();
        if(k < min.length && min[k] == 0) { min[k] = i; count++;}
      }
    }
    Set<Integer> s = new HashSet<>();
    int max = -1;
    for(int m : min) { s.add(m); max = Math.max(max, m);}
    System.out.println(s.stream().mapToInt(Integer::intValue).sum() - 1);
    System.out.println(max);
  }
  public static List<List<Integer>> getDivisorsList(int min, int n) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = min; i < n; ++i) {
      if (n % i == 0 && n / i >= i) {
        List<Integer> t = new ArrayList<>();
        t.add(i); t.add(n/i);
        res.add(t);
        if (n / i > i){
          List<List<Integer>> o = getDivisorsList(i, n / i);
          for(List<Integer> l : o) {
            l.add(i);
            res.add(l);
          }
        }
      }
    }
    return res;
  }
}
