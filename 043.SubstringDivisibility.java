import java.util.*;

class SubstringDivisibility {
  public static final int[] DIVS = {2, 3, 5, 7, 11, 13, 17};
  public static Set<Long> pandigitals = new HashSet<>();
  public static void main(String[] args) {
    generataPandigitals(0, 0, new boolean[10]);
    long sum = 0;
    top:
    for(long p : pandigitals) {
      for (int i = 0; i < DIVS.length; i++)
        if(Integer.parseInt((p+"").charAt(i+1) + "" + (p+"").charAt(i+2) + "" + (p+"").charAt(i+3))%DIVS[i] != 0) continue top;
      sum += p;
    }
    System.out.println(sum);
  }
  public static void generataPandigitals(long p, int n, boolean[] used) {
    if(n == 10) {
      pandigitals.add(p);
      return;
    }
    for(int i = 0; i < 10; i++) {
      if (used[i]) continue;
      if(n == 0 && i == 0) continue;
      used[i] = true;
      generataPandigitals(p*10 + i, n+1, used);
      used[i] = false;
    }
  }
}
