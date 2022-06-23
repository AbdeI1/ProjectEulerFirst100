public class LargeNonMersennePrime {
  public static void main(String[] args) {
    long M = 10_000_000_000L;
    long s = modExp(2, 7830457, M);
    s *= 28433;
    s %= M;
    s += 1;
    System.out.println(s);
  }
  public static long modExp(long x, int p, long M) {
    if(p == 0) { return 1;}
    if(p%2 == 0) {
      return modExp(modMult(x, x, M), p/2, M);
    } else {
      return modMult(x, modExp(x,p-1, M), M);
    }
  }
  public static long modMult(long x, long y, long M) {
    if(y == 0) { return 0; }
    if(y%2 == 0) {
      return modMult((x + x)%M, y/2, M);
    } else {
      return (x + modMult(x, y-1, M))%M;
    }
  }
}
