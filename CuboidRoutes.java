import java.io.*;
import java.util.*;

public class CuboidRoutes {
  public static void main(String[] args) {
    int cur = 2048;
    int st = cur/2;
    int tar = 1_000_000;
    while(st > 0) {
      int res = count(cur);
      if(res > tar) {
        cur -= st;
      } else {
        cur += st;
      }
      st /= 2;
    }
    System.out.println((cur+1) + ": " + count(cur+1));
  }
  public static int count(int M) {
    int count = 0;
    for(int i = 1; i <= M; i++) {
      for(int j = i; j <= M; j++) {
        for(int k = j; k <= M; k++) {
          if(isPerfectSquare(getShortestSq(i, j, k))) {
            count++;
          }
        }
      }
    }
    return count;
  }
  public static long getShortestSq(int w, int h, int l) {
    long c1 = ((long)w + h)*(w + h) + (long) l *l;
    long c2 = ((long)l + h)*(l + h) + (long) w *w;
    long c3 = ((long)w + l)*(w + l) + (long) h *h;
    return Math.min(c1, Math.min(c2, c3));
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
