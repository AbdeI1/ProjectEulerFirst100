import java.math.BigInteger;
import java.util.*;

public class SquareRootConvergents {
  public static void main(String[] args) {
    int count = 0;
    List<Integer> cfrac = new ArrayList<>();
    cfrac.add(1);
    for(int i = 0; i < 2000; i++) {
      cfrac.add(2);
    }
    int N = 1000;
    for(int i = 1; i <= N; i++) {
      BigInteger[] convergent = calc(cfrac, 0, i);
      if(convergent[0].toString().length() > convergent[1].toString().length()) count++;
    }
    System.out.println(count);
  }
  public static BigInteger[] calc(List<Integer> cfrac, int i, int e) {
    if(i >= e) return new BigInteger[]{new BigInteger(cfrac.get(i) + ""), new BigInteger("1")};
    BigInteger[] t = calc(cfrac, i+1, e);
    return new BigInteger[]{t[1].add(new BigInteger(cfrac.get(i)+"").multiply(t[0])), t[0]};
  }
}
