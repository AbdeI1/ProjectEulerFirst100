public class CountingRectangles {
  public static void main(String[] args) {
    int n = 2_000_000;
    long minDif = n;
    int minA = -1;
    for(int i = 50; i < 100; i++) {
      for(int j = 0; j < 50; j++) {
        long dif = Math.abs(n - count(i, j));
        if(dif < minDif) {
          minDif = dif;
          minA = i*j;
        }
      }
    }
    System.out.println(minA);
  }
  public static long count(int w, int h) {
    long res = 0;
    for(int a = 1; a <= w; a++) {
      for(int b = 1; b <= h; b++) {
        res += ((long) (w - a + 1)) *(h-b+1);
      }
    }
    return res;
  }
}
