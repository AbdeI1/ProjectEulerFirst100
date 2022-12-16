import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;

class DiophantineEquation {
  public static void main(String[] args) {
    Set<Integer> squares = new HashSet<>();
    int D = 1000;
    for(int i = 0; i*i <= D; i++) {
      squares.add(i*i);
    }
    BigInteger maxX = new BigInteger("-1"); int maxD = -1;
    for(int i = 0 ; i <= D; i++) {
      if(squares.contains(i)){ continue; }
      BigInteger x = solveDiophantine(i);
      if(x.compareTo(maxX) > 0) {
        maxX = x;
        maxD = i;
      }
    }
    System.out.println(maxD);
  }
//  public static BigInteger solveDiophantine2(int D) {
//    BigDecimal d = new BigDecimal(D + "");
//    d = d.sqrt(new MathContext(1000));
//    String[] ds = d.toString().split("\\.");
//    BigInteger[] f = new BigInteger[]{new BigInteger(ds[0]), new BigInteger("1")};
//    BigInteger T = new BigInteger("10");
//    for(int i = 0; i < ds[1].length(); i++) {
//      f[0] = f[0].multiply(T).add(f[1].multiply(new BigInteger(ds[1].charAt(i) + "")));
//      f[1] = f[1].multiply(T);
//      BigInteger G = gcd(f[0], f[1]);
//      f[0] = f[0].divide(G);
//      f[1] = f[1].divide(G);
//      System.out.println(f[0].multiply(f[0]).subtract(f[1].multiply(f[1]).multiply(new BigInteger(D + ""))));
//      if(f[0].multiply(f[0]).subtract(f[1].multiply(f[1]).multiply(new BigInteger(D + ""))).toString().equals("1")) {
//        System.out.println("found");
//        return f[0];
//      }
//      T = T.multiply(new BigInteger("10"));
//    }
//    return new BigInteger("0");
//  }
  public static BigInteger solveDiophantine(int D) {
    BigDecimal d = new BigDecimal(D + "");
    d = d.sqrt(new MathContext(100));
    List<Integer> cfrac = cfrac(d);
    for(int i = 0; i < cfrac.size(); i++) {
      BigInteger[] xy = calc(cfrac, 0, i);
      if(xy[0].multiply(xy[0]).subtract(xy[1].multiply(xy[1]).multiply(new BigInteger(D + ""))).toString().equals("1")) {
        return xy[0];
      }
    }
    return new BigInteger("0");
  }
  public static List<Integer> cfrac(int N) {
    List<Integer> X = new ArrayList<>();
    int m = (int)Math.floor(Math.sqrt(N));
    X.add(m);
    int p = m;
    int q = 1;
    for(int i = 1; i < 100; i++) {
      q = (N - p*p)/(q);
      int d = (p+m)/q;
      p = d*q - p;
      X.add(d);
    }
    return X;
  }
  public static List<Integer> cfrac(BigDecimal x) {
    List<Integer> X = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      X.add(x.intValue());
      x = x.subtract(new BigDecimal(x.intValue()));
      x = new BigDecimal("1").divide(x, new MathContext(100));
    }
    return X;
  }
  public static BigInteger[] calc(List<Integer> cfrac, int i, int e) {
    if(i >= e) {
      return new BigInteger[]{new BigInteger(cfrac.get(i) + ""), new BigInteger("1")};
    }
    BigInteger[] t = calc(cfrac, i+1, e);
    return new BigInteger[]{t[1].add(new BigInteger(cfrac.get(i)+"").multiply(t[0])), t[0]};
  }
  public static BigInteger gcd(BigInteger a, BigInteger b) {
    if(b.toString().equals("0")) { return a; }
    return gcd(b, a.mod(b));
  }
}
