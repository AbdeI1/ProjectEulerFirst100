import java.math.BigInteger;
import java.util.*;

class ConvergentsOfE {
  public static void main(String[] args) {
    List<Integer> E = new ArrayList<>();
    E.add(2);
    E.add(1);
    E.add(2);
    for(int i = 2; E.size() < 100; i++) {
      E.add(1);
      E.add(1);
      E.add(2*i);
    }
    int n = 100;
    System.out.println(calc(E, 0, n-1)[0].toString().chars().map(c -> c - '0').sum());
  }
  public static BigInteger[] calc(List<Integer> cfrac, int i, int e) {
    if(i >= e) {
      return new BigInteger[]{new BigInteger(cfrac.get(i) + ""), new BigInteger("1")};
    }
    BigInteger[] t = calc(cfrac, i+1, e);
    return new BigInteger[]{t[1].add(new BigInteger(cfrac.get(i)+"").multiply(t[0])), t[0]};
  }
}
