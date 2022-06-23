import java.math.BigInteger;

public class ReciprocalCycles {
  public static void main(String[] args) {
    int max = -1; int maxD = -1;
    for(int i = 2; i < 1000; i++) {
      int c = getCycleLength(i);
      if(c > max) {
        max = c;
        maxD = i;
      }
    }
    System.out.println(maxD);
  }
  public static int getCycleLength(int d) {
    int n = d;
    while(d%2 == 0) d /= 2;
    while(d%5 == 0) d /= 5;
    if(d == 1) return 0;
    int lpow = 1;
    while(true) {
      for(int mpow = lpow-1; mpow > -1; mpow--)
        if(new BigInteger("1" + "0".repeat(lpow)).subtract(new BigInteger("1" + "0".repeat(mpow))).mod(new BigInteger(n + "")).toString().equals("0"))
          return lpow-mpow;
      lpow++;
    }
  }
}
