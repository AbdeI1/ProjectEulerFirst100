class SelfPowers {
  public static void main(String[] args) {
    long ans = 0; long M = 10_000_000_000L;
    for(int i = 1; i <= 1000; i++) {
      ans += modExp(i, i, M);
      ans %= M;
    }
    System.out.println(ans);
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
