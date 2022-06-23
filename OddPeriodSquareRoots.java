import java.io.*;
import java.util.*;

public class OddPeriodSquareRoots {
  public static void main(String[] args) {
    Set<Integer> squares = new HashSet<>();
    int D = 10_000;
    for(int i = 0; i*i <= D; i++) {
      squares.add(i*i);
    }
    int count = 0;
    for(int N = 0; N <= D; N++) {
      if(squares.contains(N)) { continue; }
      if(getPeriod(N)%2 == 1) {
        count++;
      }
    }
    System.out.println(count);
  }
  public static int getPeriod(int N) {
    int m = (int)Math.floor(Math.sqrt(N));
    int p = m;
    int q = 1;
    int period = 1;
    while(true) {
      q = (N - p*p)/(q);
      int d = (p+m)/q;
      if(d == 2*m) {
        break;
      }
      period++;
      p = d*q - p;
    }
    return period;
  }
}
