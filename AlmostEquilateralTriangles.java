public class AlmostEquilateralTriangles {
  public static void main(String[] args) {
    long r = 0;
    for(long p = 4; p <= 1_000_000_000; p += 2) {
      long x; boolean isIntegral;
      x = (p-1)/3;
      isIntegral = false;
      if(p%2 == 0) {
        long s = p/2;
        long sq = s*s - x*s - s;
        isIntegral = isPerfectSquare(sq);
      } else {
        long sq = p*p - 2*x*p - 2*p;
        if(sq%16 == 0) {
          sq /= 16;
          isIntegral = isPerfectSquare(sq);
        }
      }
      if(isIntegral) {
        r += p;
      }
      p++;
      if(p > 1_000_000_000) { continue; }
      x = (p+2)/3;
      isIntegral = false;
      if(p%2 == 0) {
        long s = p/2;
        long sq = s*s - x*s + s;
        isIntegral = isPerfectSquare(sq);
      } else {
        long sq = p*p - 2*x*p + 2*p;
        if(sq%16 == 0) {
          sq /= 16;
          isIntegral = isPerfectSquare(sq);
        }
      }
      if(isIntegral) {
        r += p;
      }
    }
    System.out.println(r-4);
  }
  public static boolean isPerfectSquare(long sq) {
    long h = (long)Math.ceil(Math.sqrt(sq)) + 1;
    long l = (long)Math.floor(Math.sqrt(sq)) - 1;
    for(long n = l; n <= h; n++) {
      if(n*n == sq) { return true; }
    }
    return false;
  }
}
